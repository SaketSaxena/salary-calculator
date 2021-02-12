import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TaxCalculatorTest {

    private TaxCalculator taxCalculator;

    @BeforeEach
    void setUp() {
        taxCalculator = new TaxCalculator();
    }

    @Test
    void should_calculate_tax_when_income_is_below_250000() {
        long tax = taxCalculator.calculateTax(200000);

        assertEquals(0, tax);
    }

    @Test
    void should_calculate_tax_when_income_is_between_250001_and_500000() {
        long tax = taxCalculator.calculateTax(400000);

        assertEquals(7500, tax);
    }

    @Test
    void should_calculate_tax_when_income_is_500000() {
        long tax = taxCalculator.calculateTax(500000);

        assertEquals(12500, tax);
    }

    @Test
    void should_calculate_tax_when_income_is_between_500001_and_1000000() {
        long tax = taxCalculator.calculateTax(900000);

        assertEquals(92500, tax);
    }

    @Test
    void should_calculate_tax_when_income_is_above_1000000() {
        long tax = taxCalculator.calculateTax(1200000);

        assertEquals(172500, tax);
    }

    @Test
    void should_throw_illegal_argument_exception_if_income_is_less_than_1() {
        assertThrows(IllegalArgumentException.class, () -> taxCalculator.calculateTax(-2000));
    }
}