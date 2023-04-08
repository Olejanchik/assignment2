package ua.shpp.mjava.okuzmenko;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.BigInteger;

public class MultiplyingValues {
    Logger logger = LoggerFactory.getLogger(MultiplyingValues.class);
    private BigInteger minValueBI;
    private BigInteger maxValueBI;
    private BigDecimal minValueBD;
    private BigDecimal maxValueBD;
    private final int increment;

    public MultiplyingValues(String systemProperty) {
        SetUpConfigurations config = new SetUpConfigurations();
        this.increment = Integer.parseInt(config.getPropertyIncrementValue());

        if (systemProperty.equals("byte") || systemProperty.equals("short")
        || systemProperty.equals("int") || systemProperty.equals("long")) {
            logger.debug("BigInteger Values applied successful.");
            long a = Long.parseLong(config.getPropertyMinValue());
            long b = Long.parseLong(config.getPropertyMaxValue());
            this.minValueBI = BigInteger.valueOf(a);
            this.maxValueBI = BigInteger.valueOf(b);
        } else if (systemProperty.equals("float") || systemProperty.equals("double")) {
            logger.debug("BigDecimal Values applied successful.");
            double a = Double.parseDouble(config.getPropertyMinValue());
            double b = Double.parseDouble(config.getPropertyMaxValue());
            this.minValueBD = BigDecimal.valueOf(a);
            this.maxValueBD = BigDecimal.valueOf(b);
        }
        logger.debug("Constructor works good");
    }

    public BigInteger getMinValueBI() {
        return minValueBI;
    }

    public BigInteger getMaxValueBI() {
        return maxValueBI;
    }

    public BigDecimal getMinValueBD() {
        return minValueBD;
    }

    public BigDecimal getMaxValueBD() {
        return maxValueBD;
    }

    public int getIncrement() {
        return increment;
    }
}
