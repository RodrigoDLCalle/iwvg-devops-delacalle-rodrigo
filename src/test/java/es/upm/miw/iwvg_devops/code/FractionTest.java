package es.upm.miw.iwvg_devops.code;

import es.upm.miw.iwvg_devops.code.Fraction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {

    private Fraction fraction;

    @BeforeEach
    void setUp() {
        fraction = new Fraction(2, 4);
    }

    @Test
    void testConstructorWithNumeratorAndDenominator() {
        assertEquals(2, fraction.getNumerator());
        assertEquals(4, fraction.getDenominator());
    }

    @Test
    void testDefaultConstructor() {
        Fraction defaultFraction = new Fraction();
        assertEquals(1, defaultFraction.getNumerator());
        assertEquals(1, defaultFraction.getDenominator());
    }

    @Test
    void testGetNumerator() {
        assertEquals(2, fraction.getNumerator());
    }

    @Test
    void testSetNumerator() {
        fraction.setNumerator(3);
        assertEquals(3, fraction.getNumerator());
    }

    @Test
    void testGetDenominator() {
        assertEquals(4, fraction.getDenominator());
    }

    @Test
    void testSetDenominator() {
        fraction.setDenominator(5);
        assertEquals(5, fraction.getDenominator());
    }

    @Test
    void testDecimal() {
        assertEquals(0.5, fraction.decimal(), 0.001);
    }

    @Test
    void testToString() {
        String expected = "Fraction{numerator=2, denominator=4}";
        assertEquals(expected, fraction.toString());
    }

    @Test
    public void testIsProper() {
        assertTrue(fraction.isProper());

        Fraction improperFraction = new Fraction(5, 4);
        assertFalse(improperFraction.isProper());
    }

    @Test
    public void testIsImproper() {
        assertFalse(fraction.isImproper());

        Fraction improperFraction = new Fraction(5, 4);
        assertTrue(improperFraction.isImproper());
    }

    @Test
    public void testIsEquivalent() {
        Fraction equivalentFraction = new Fraction(1, 2);
        assertTrue(fraction.isEquivalent(equivalentFraction));

        Fraction nonEquivalentFraction = new Fraction(3, 5);
        assertFalse(fraction.isEquivalent(nonEquivalentFraction));
    }

    @Test
    public void testAdd() {
        Fraction otherFraction = new Fraction(1, 3);
        Fraction result = fraction.add(otherFraction);
        assertEquals(new Fraction(5, 6), result);
    }

    @Test
    public void testMultiply() {
        Fraction otherFraction = new Fraction(3, 5);
        Fraction result = fraction.multiply(otherFraction);
        assertEquals(new Fraction(3, 10), result);
    }

    @Test
    public void testDivide() {
        Fraction otherFraction = new Fraction(1, 2);
        Fraction result = fraction.divide(otherFraction);
        assertEquals(new Fraction(4, 1), result);
    }
}

