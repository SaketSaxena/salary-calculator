Create a `TaxCalculator` class with TDD Approach which will have a method with below signature

`public long calculateTax(long income)`

The above method should have the below functionality:

- If income is Upto Rs. 2,50,000, tax is 0.
- If income is Between Rs. 2,50,001 and Rs. 5,00,000, tax will be 5% of Income exceeding Rs. 250,000.
- If income is Between Rs. 5,00,001 to Rs. 10,00,000, tax will be Rs. 12,500 + 20% of Income exceeding Rs. 500,000.
- If income is Above Rs. 10,00,000, tax will be Rs. 1,12,500 + 30% of Income exceeding of Rs 10,00,000.

Please follow the TDD approach for arriving to the final solution.

Mockito Example
-
Create a class `OnHandSalaryCalculator` with TDD Approach which will have a method with below signature

`public long getOnHandSalary(long income)`

The above method should have the below functionality:

- It should call the tax calculator with income and return the income after deducting the tax from the income.

Note: Use Mockito to mock the `TaxCalculator` class.
