package ua.shpp.mjava.okuzmenko;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class MultiplyingValuesTest {
    MultiplyingValues valuesInt = new MultiplyingValues("int");
    MultiplyingValues valuesDouble = new MultiplyingValues("double");

    @Test
    void getMinValueBI() {
        BigInteger value = valuesInt.getMinValueBI();

        assertEquals(BigInteger.valueOf(2), value);
    }

    @Test
    void getMaxValueBI() {
        BigInteger value = valuesInt.getMaxValueBI();

        assertEquals(BigInteger.valueOf(10), value);
    }

    @Test
    void getMinValueBD() {
        BigDecimal value = valuesDouble.getMinValueBD();

        assertEquals(BigDecimal.valueOf(2.0), value);
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