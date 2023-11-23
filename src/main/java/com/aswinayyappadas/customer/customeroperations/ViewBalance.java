package com.aswinayyappadas.customer.customeroperations;
import com.aswinayyappadas.customer.ICustomerAccount;
import java.util.List;

public class ViewBalance implements ICustomerAccount {

    private final List<Double> transactionList;

    public ViewBalance(List<Double> transactionList) {
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
        return 0.0;
    }


    @Override
    public void checkBalance(double balance) {
        //logTransaction(balance);  // Log the current balance
        System.out.println("Current Balance: " + balance);
    }

    @Override
    public void showTransactions() {

    }

    private void logTransaction(double amount) {
        // Log the transaction amount to the transactionList
        transactionList.add(amount);
    }
}
