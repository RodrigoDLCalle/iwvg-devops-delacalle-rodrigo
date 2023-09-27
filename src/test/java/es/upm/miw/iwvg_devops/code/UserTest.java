package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;
    private List<Fraction> fractions;

    @BeforeEach
    public void setUp() {
        fractions = new ArrayList<>();
        fractions.add(new Fraction(1, 2));
        fractions.add(new Fraction(3, 4));
        user = new User("1", "John", "Doe", fractions);
    }

    @Test
    void testGetId() {
        assertEquals("1", user.getId());
    }

    @Test
    void testGetName() {
        assertEquals("John", user.getName());
    }

    @Test
    void testSetName() {
        user.setName("Jane");
        assertEquals("Jane", user.getName());
    }

    @Test
    void testGetFamilyName() {
        assertEquals("Doe", user.getFamilyName());
    }

    @Test
    void testSetFamilyName() {
        user.setFamilyName("Smith");
        assertEquals("Smith", user.getFamilyName());
    }

    @Test
    void testGetFractions() {
        assertEquals(fractions, user.getFractions());
    }

    @Test
    void testSetFractions() {
        List<Fraction> newFractions = new ArrayList<>();
        newFractions.add(new Fraction(1, 3));
        user.setFractions(newFractions);
        assertEquals(newFractions, user.getFractions());
    }

    @Test
    void testAddFraction() {
        Fraction newFraction = new Fraction(2, 5);
        user.addFraction(newFraction);
        assertTrue(user.getFractions().contains(newFraction));
    }

    @Test
    void testFullName() {
        assertEquals("John Doe", user.fullName());
    }

    @Test
    void testInitials() {
        assertEquals("J.", user.initials());
    }

    @Test
    void testToString() {
        String expected = "User{id='1', name='John', familyName='Doe', fractions=[Fraction: [1/2], Fraction: [3/4]]}";
        assertEquals(expected, user.toString());
    }
}