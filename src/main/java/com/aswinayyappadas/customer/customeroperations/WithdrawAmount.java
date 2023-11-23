package com.aswinayyappadas.customer.customeroperations;
import com.aswinayyappadas.customer.ICustomerAccount;
import java.util.List;
public class WithdrawAmount implements ICustomerAccount {
    private final List<Double> transactionList;

    public WithdrawAmount(List<Double> transactionList) {

        this.transactionList = transactionList;
    }
    public String getAccountNumber() {
        return null;
    }

    public List<Double> getTransactionList() {
        return null;
    }

    public double withdraw(double amount, double balance) {
        if (balance >= amount) {
            balance -= amount;
            logTransaction(amount);  // Log a negative amount for withdrawal
        }
        return balance;
    }
    public double deposit(double amount, double balance) {
        return 0.0;
    }
    public void checkBalance(double balance) {

    }
    public void showTransactions() {

    }
    private void logTransaction(double amount) {
        // Log the transaction amount to the transactionList
        transactionList.add(-amount);
    }
}
