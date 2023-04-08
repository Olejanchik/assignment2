package ua.shpp.mjava.okuzmenko;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class MultiplyTableGeneratorTest {

    @Test
    void multiplyBigInteger() {

        BigInteger result = MultiplyTableGenerator.multiplyBigInteger(1,2);

        assertEquals(BigInteger.valueOf(2), result);
    }

    @Test
    void multiplyBigDecimal() {

        BigDecimal result = MultiplyTableGenerator.multiplyBigDecimal(1.0, 2.0);

        assertEquals(BigDecimal.valueOf(2.0), result);
    }


}