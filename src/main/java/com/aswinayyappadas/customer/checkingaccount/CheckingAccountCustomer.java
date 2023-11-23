package com.aswinayyappadas.customer.checkingaccount;
import com.aswinayyappadas.customer.ICustomerAccount;
import com.aswinayyappadas.customer.ITransactionProvider;
import com.aswinayyappadas.personaldetails.PersonalDetails;
import java.util.List;
import java.util.UUID;

public class CheckingAccountCustomer extends PersonalDetails implements ICustomerAccount {
    private double balance;  // Change to Double
    private final List<Double> transactionList;
    private final ICustomerAccount withdrawOperation;
    private final ICustomerAccount viewBalanceOperation;
    private final ICustomerAccount depositOperation;
    private final ICustomerAccount showTransactionsOperation;
    private final ITransactionProvider transactionProvider;
    private String accountNumber;


    public Double getBalance() {
        return this.balance;
    }
    public CheckingAccountCustomer(List<Double> transactionList,
                                   ICustomerAccount withdrawOperation,
                                   ICustomerAccount viewBalanceOperation,
                                   ICustomerAccount depositOperation,
                                   ICustomerAccount showTransactionsOperation,
                                   ITransactionProvider transactionProvider) {
        this.balance = 0.0;
        this.transactionList = transactionList;
        this.withdrawOperation = withdrawOperation;
        this.viewBalanceOperation = viewBalanceOperation;
        this.depositOperation = depositOperation;
        this.showTransactionsOperation = showTransactionsOperation;
        this.transactionProvider = transactionProvider;
        this.setAccountNumber(generateAccountNumber());
    }

    private void setAccountNumber(String s) {
        this.accountNumber = s;

    }

    private String generateAccountNumber() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-", "");
    }
    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public List<Double> getTransactionList() {
        return transactionList;
    }

    @Override
    public double withdraw(double amount, double balance) {
        this.balance =  withdrawOperation.withdraw(amount, balance);
        transactionProvider.getTransactionMap().put(this.getAccountNumber(), this.getTransactionList());
        return 0.0;
    }

    @Override
    public double deposit(double amount, double balance) {
        this.balance = depositOperation.deposit(amount, balance);
        transactionProvider.getTransactionMap().put(this.getAccountNumber(), this.getTransactionList());
        return 0.0;
    }

    @Override
    public void checkBalance(double balance) {
        viewBalanceOperation.checkBalance(balance);
    }

    @Override
    public void showTransactions() {
        showTransactionsOperation.showTransactions();
    }
}
