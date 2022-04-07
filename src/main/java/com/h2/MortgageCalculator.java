package com.h2;

import java.text.DecimalFormat;

public class MortgageCalculator {

    private long loanAmount;
    private int termInYears;
    private float annualRate;
    private double monthlyPayment;

    public MortgageCalculator(long loanAmount, int termInYears, float annualRate) {
        this.loanAmount = loanAmount;
        this.termInYears = termInYears;
        this.annualRate = annualRate;
    }

    public static void main(String[] args) {

        long loanAmount = Utilities.getLongValue(args[0]);
        int termInYears = Utilities.getIntValue(args[1]);
        float annualRate = Utilities.getFloatValue(args[2]);

        MortgageCalculator calculator = new MortgageCalculator(loanAmount, termInYears, annualRate);

        calculator.calculateMonthlyPayment();

        System.out.println(calculator.toString());
    }

    private int getNumberOfPayments() {
        return termInYears*12;
    }

    private float getMonthlyInterestRate() {
        return annualRate/(100 * 12);
    }

    public void calculateMonthlyPayment() {
        long p = this.loanAmount;
        float r = getMonthlyInterestRate();
        int n = getNumberOfPayments();

        this.monthlyPayment = p * (((r * Math.pow(1 + r, n))) / ((Math.pow(1 + r, n)) - 1));
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("####0.00");
        return "monthlyPayment: " + df.format(monthlyPayment);
    }
}
