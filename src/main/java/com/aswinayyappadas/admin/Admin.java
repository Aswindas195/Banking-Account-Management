package com.aswinayyappadas.admin;

import com.aswinayyappadas.customer.IInterestRateProvider;
import com.aswinayyappadas.customer.ITransactionProvider;
import com.aswinayyappadas.personaldetails.PersonalDetails;

import java.util.HashMap;
import java.util.List;

public class Admin extends PersonalDetails implements IAdmin, IInterestRateProvider {

    private final ITransactionProvider transactionProvider;
    private static double interestRate;

    public Admin(ITransactionProvider transactionProvider) {
        this.transactionProvider = transactionProvider;
    }
    @Override
    public void showCustomerTransactions() {
        System.out.println(getTransactionMap());
    }

    @Override
    public HashMap<String, List<Double>> getTransactionMap() {
        return transactionProvider.getTransactionMap();
    }

    @Override
    public double setInterestRate(double newInterestRate) {
        interestRate = newInterestRate;
        return interestRate;
    }
    @Override
    public double getInterestRate() {
        return interestRate;
    }
}
