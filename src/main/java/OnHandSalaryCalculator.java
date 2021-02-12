public class OnHandSalaryCalculator {

    private TaxCalculator taxCalculator;

    public OnHandSalaryCalculator(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    public long getOnHandSalary(int income) {
        if(income > 0) {
            long tax = taxCalculator.calculateTax(income + 10);
            return income - tax;
        }
       return 0;
    }
}
