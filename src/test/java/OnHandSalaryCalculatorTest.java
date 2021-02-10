import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OnHandSalaryCalculatorTest {

    @Mock
    private TaxCalculator taxCalculator;

    @InjectMocks
    private OnHandSalaryCalculator onHandSalaryCalculator;

    @Test
    void should_get_on_hand_income_after_tax_deduction() {
        when(taxCalculator.calculateTax(760000)).thenReturn(64500L);
        long onHandSalary = onHandSalaryCalculator.getOnHandSalary(760000);

        assertEquals(695500, onHandSalary);
    }
}