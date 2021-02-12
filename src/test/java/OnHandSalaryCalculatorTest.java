import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OnHandSalaryCalculatorTest {

    @Mock
    private TaxCalculator taxCalculator;

    @InjectMocks
    private OnHandSalaryCalculator onHandSalaryCalculator;

    @Captor
    ArgumentCaptor<Long> incomeCaptor;

    @Test
    void should_get_on_hand_income_after_deducting_tax() {
        when(taxCalculator.calculateTax(anyLong())).thenReturn(64500L);

        long salary = onHandSalaryCalculator.getOnHandSalary(760000);

        assertEquals(695500, salary);
    }

    @Test
    void should_check_if_tax_calculator_is_invoked() {
        when(taxCalculator.calculateTax(anyLong())).thenReturn(64500L);

       onHandSalaryCalculator.getOnHandSalary(760000);

        verify(taxCalculator, times(1)).calculateTax(anyLong());
    }

    @Test
    void should_not_invoke_tax_calculator_if_income_is_less_than_0() {
        onHandSalaryCalculator.getOnHandSalary(-2000);

        verify(taxCalculator, never()).calculateTax(anyLong());
    }

    @Test
    void should_check_tax_calculator_is_invoked_with_correct_income() {
        when(taxCalculator.calculateTax(anyLong())).thenReturn(64500L);

        onHandSalaryCalculator.getOnHandSalary(760000);

        verify(taxCalculator).calculateTax(incomeCaptor.capture());
        assertEquals(760010, incomeCaptor.getValue());
    }
}