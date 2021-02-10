public class OnHandSalaryCalculator {

    private TaxCalculator taxCalculator;

    public OnHandSalaryCalculator(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    public long getOnHandSalary(long income) {
        long tax = taxCalculator.calculateTax(income);
        return income - tax;
    }
}
