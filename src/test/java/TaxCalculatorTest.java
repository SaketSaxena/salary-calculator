import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TaxCalculatorTest {

    TaxCalculator taxCalculator;

    @BeforeEach
    void setUp() {
        taxCalculator = new TaxCalculator();
    }

    @Test
    void should_return_0_tax_if_income_is_below_250000() {

        long result = taxCalculator.calculateTax(200000);

        assertEquals(0, result);
    }

    @Test
    void should_return_tax_if_income_is_between_250001_and_500000() {

        long result = taxCalculator.calculateTax(400000);

        assertEquals(7500, result);
    }

    @Test
    void should_return_tax_if_income_is_between_500001_and_1000000() {

        long result = taxCalculator.calculateTax(900000);

        assertEquals(92500, result);
    }

    @Test
    void should_return_tax_if_income_is_above_1000000() {

        long result = taxCalculator.calculateTax(1200000);

        assertEquals(172500, result);
    }

    @Test
    void should_throw_IllegalArgumentException_when_income_is_below_1() {
        assertThrows(IllegalArgumentException.class,
                () -> taxCalculator.calculateTax(-2000));
    }

    @Test
    void should_return_tax_if_income_is_500000() {
        long result = taxCalculator.calculateTax(500000);

        assertEquals(12500, result);
    }
}