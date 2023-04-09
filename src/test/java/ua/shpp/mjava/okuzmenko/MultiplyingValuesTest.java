package ua.shpp.mjava.okuzmenko;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class MultiplyingValuesTest {
    MultiplyingValues valuesInt;
    MultiplyingValues valuesDouble;
    @BeforeEach
    public void before() {
        valuesInt = new MultiplyingValues("int");
        valuesDouble = new MultiplyingValues("double");
    }

    @Test
    void getMinValueBI() {
        BigInteger value = valuesInt.getMinValueBI();

        assertEquals(BigInteger.valueOf(1), value);
    }

    @Test
    void getMaxValueBI() {
        BigInteger value = valuesInt.getMaxValueBI();

        assertEquals(BigInteger.valueOf(10), value);
    }

    @Test
    void getMinValueBD() {
        BigDecimal value = valuesDouble.getMinValueBD();

        assertEquals(BigDecimal.valueOf(1.0), value);
    }

    @Test
    void getMaxValueBD() {
        BigDecimal value = valuesDouble.getMaxValueBD();

        assertEquals(BigDecimal.valueOf(10.0), value);
    }

    @Test
    void getIncrement() {
        int value = valuesInt.getIncrement();

        assertEquals(1, value);
    }
}