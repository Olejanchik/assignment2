package ua.shpp.mjava.okuzmenko;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.BigInteger;

public class MultiplyTableGenerator {
    private static final String PROPERTY = System.getProperty("type", "int");
    private static final MultiplyingValues VALUES = new MultiplyingValues(PROPERTY);
    private static final Logger logger = LoggerFactory.getLogger(MultiplyTableGenerator.class);

    public static void main(String[] args) {
        if (PROPERTY.equals("byte") || PROPERTY.equals("short") || PROPERTY.equals("int") || PROPERTY.equals("long")){
            BigInteger minValue = VALUES.getMinValueBI();
            BigInteger maxValue = VALUES.getMaxValueBI();
            int increment = VALUES.getIncrement();
            logger.debug("starting generate table:");
            generateTableBI(minValue, maxValue, increment);
            logger.debug("Generating ended.");
        } else if (PROPERTY.equals("float") || PROPERTY.equals("double")) {
            BigDecimal minValue = VALUES.getMinValueBD();
            BigDecimal maxValue = VALUES.getMaxValueBD();
            int increment = VALUES.getIncrement();
            logger.debug("starting generate table:");
            generateTableBD(minValue, maxValue, increment);
            logger.debug("Generating ended.");
        }
    }

    private static void generateTableBD(BigDecimal minValue, BigDecimal maxValue, int increment) {
        BigDecimal value1 = minValue;
        BigDecimal value2;

        for (; value1.compareTo(maxValue) <= 0; value1 = value1.add(BigDecimal.valueOf(increment))) {
            value2 = minValue;
            StringBuilder row = new StringBuilder();
            for (; value2.compareTo(maxValue) <= 0; value2 = value2.add(BigDecimal.valueOf(increment))) {
                BigDecimal result = MultiplyTableGenerator.multiplyBigDecimal(value1.doubleValue(), value2.doubleValue());
                row.append(String.format("%10s", result));
            }
            logger.info(row.toString());
        }
    }

    private static void generateTableBI(BigInteger minValue, BigInteger maxValue, long increment) {
        BigInteger value1 = minValue;
        BigInteger value2;

        for (; value1.compareTo(maxValue) <= 0; value1 = value1.add(BigInteger.valueOf(increment))) {
            value2 = minValue;
            StringBuilder row = new StringBuilder();
            for (; value2.compareTo(maxValue) <= 0; value2 = value2.add(BigInteger.valueOf(increment))) {
                BigInteger result = MultiplyTableGenerator.multiplyBigInteger(value1.longValue(), value2.longValue());
                row.append(String.format("%20s", result));
            }
            logger.info(row.toString());
        }
    }

    public static BigInteger multiplyBigInteger(long a, long b) {
        return BigInteger.valueOf(a * b);
    }

    public static BigDecimal multiplyBigDecimal(double a, double b) {
        return BigDecimal.valueOf(a * b);
    }
}
