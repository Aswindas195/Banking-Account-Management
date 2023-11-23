package com.aswinayyappadas.customer.customeroperations;
import com.aswinayyappadas.customer.ICustomerAccount;
import com.aswinayyappadas.customer.ITransactionProvider;

import java.util.List;

public class DepositAmount implements ICustomerAccount {

    private final List<Double> transactionList;


    public DepositAmount(List<Double> transactionList) {
        this.transactionList = transactionList;
    }

    @Override
    public String getAccountNumber() {
        return null;
    }

    @Override
    public List<Double> getTransactionList() {
        return null;
    }

    @Override
    public double withdraw(double amount, double balance) {
        return 0.0;
    }


    @Override
    public double deposit(double amount, double balance) {
        balance += amount;
        logTransaction(amount);  // Log a positive amount for deposit
        return balance;
    }

    @Override
    public void checkBalance(double balance) {

    }

    @Override
    public void showTransactions() {

    }


    private void logTransaction(double amount) {
        // Log the transaction amount to the transactionList
        transactionList.add(+amount);
    }
}
