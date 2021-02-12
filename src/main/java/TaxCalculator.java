public class TaxCalculator {

    public long calculateTax(long income) {

        if(income <= 0) {
            throw new IllegalArgumentException("Income is not valid");
        }

        if(income > 250000 && income <= 500000){
            return (long) ((income - 250000)*0.05);
        }

        if(income > 500000 && income <= 1000000){
            return (long) (((income - 500000)*0.20) + 12500);
        }

        if(income > 1000000) {
            return (long) (((income - 1000000)*0.30)+ 112500);
        }
        return 0;
    }
}
