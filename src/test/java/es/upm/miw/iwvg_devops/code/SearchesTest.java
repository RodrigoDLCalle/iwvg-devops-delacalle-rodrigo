package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchesTest {

    private List<User> users;
    private Searches searches;

    @BeforeEach
    void setUp() {
        users = new ArrayList<>();

        List<Fraction> fractions1 = new ArrayList<>();
        fractions1.add(new Fraction(1, 2));
        fractions1.add(new Fraction(3, 4));
        User user1 = new User("1", "Rodrigo", "Calle", fractions1);

        List<Fraction> fractions2 = new ArrayList<>();
        fractions2.add(new Fraction(2, 5));
        fractions2.add(new Fraction(7, 6));
        User user2 = new User("2", "Lucia", "Gonzalez", fractions2);

        List<Fraction> fractions3 = new ArrayList<>();
        fractions3.add(new Fraction(5, 3));
        fractions3.add(new Fraction(10, 5));
        User user3 = new User("3", "Paula", "Alonso", fractions3);

        users.add(user1);
        users.add(user2);
        users.add(user3);

        searches = new Searches(users);
    }

    @Test
    void testFindUserIdBySomeProperFraction() {

        Stream<String> result = searches.findUserIdBySomeProperFraction();

        List<String> resultList = result.toList();

        assertEquals(2, resultList.size());
        assertEquals("1", resultList.get(0));
        assertEquals("2", resultList.get(1));
    }

    @Test
     void testFindDecimalImproperFractionByUserName() {

        Stream<Double> result = searches.findDecimalImproperFractionByUserName("Paula");
        List<Double> resultList = result.toList();

        assertEquals(2, resultList.size());
        assertEquals(1.66, resultList.get(0), 0.01);
    }

    @Test
    void testFindUserFamilyNameByAllNegativeSignFractionDistinct() {
        Stream<String> result = searches.findUserFamilyNameByAllNegativeSignFractionDistinct();

        List<String> resultList = result.toList();

        // Aserciones
        assertEquals(0, resultList.size());
    }
}
