package com.aswinayyappadas.customer;

import java.util.List;

public interface ICustomerAccount {
    String getAccountNumber();
    List<Double> getTransactionList();
    /**
         * Withdraws the specified amount from the account.
         * @param amount The amount to withdraw.
         * @return true if the withdrawal was successful, false otherwise.
     */
    double withdraw(double amount, double balance);
    /**
     * Deposits a specified amount from the account.
     * @param amount The amount to deposit.
     * @return true if the withdrawal was successful, false otherwise.
     */
    double deposit(double amount, double balance);
    void checkBalance(double balance);
    void showTransactions();
}
