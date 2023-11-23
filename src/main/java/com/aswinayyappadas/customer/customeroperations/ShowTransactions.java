package com.aswinayyappadas.customer.customeroperations;
import com.aswinayyappadas.customer.ICustomerAccount;
import java.util.List;

public class ShowTransactions implements ICustomerAccount {
    private final List<Double> transactionList;

    public ShowTransactions(List<Double> transactionList) {
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
        return 0;
    }

    @Override
    public double deposit(double amount, double balance) {
        return 0;
    }

    @Override
    public void checkBalance(double balance) {

    }

    @Override
    public void showTransactions() {
        System.out.println("Transactions = " + transactionList);
    }
}
