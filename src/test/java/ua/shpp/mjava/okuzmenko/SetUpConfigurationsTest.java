package ua.shpp.mjava.okuzmenko;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SetUpConfigurationsTest {

    private final SetUpConfigurations table = new SetUpConfigurations();

    @Test
    void tablePropertiesMinValueTest() {
        String value = table.getPropertyMinValue();

        assertEquals("1", value);
    }

    @Test
    void tablePropertiesMaxValueTest() {
        String value = table.getPropertyMaxValue();

        assertEquals("10", value);
    }

    @Test
    void tablePropertiesIncrementValueTest() {
        String value = table.getPropertyIncrementValue();

        assertEquals("1", value);
    }
}