package ua.shpp.mjava.okuzmenko;

import org.junit.jupiter.api.Test;

import java.util.Properties;
import static java.util.Objects.isNull;

import static org.junit.jupiter.api.Assertions.*;

class SetUpConfigurationsTest {

    private final SetUpConfigurations table = new SetUpConfigurations();

    @Test
    public void tablePropertiesMinValueTest() {
        String value = table.getPropertyMinValue();

        assertEquals("1", value);
    }

    @Test
    public void tablePropertiesMaxValueTest() {
        String value = table.getPropertyMaxValue();

        assertEquals("10", value);
    }

    @Test
    public void tablePropertiesIncrementValueTest() {
        String value = table.getPropertyIncrementValue();

        assertEquals("1", value);
    }
}