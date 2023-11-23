package com.aswinayyappadas.customer.savingaccount;
import com.aswinayyappadas.admin.Admin;
import com.aswinayyappadas.customer.ICustomerAccount;
import com.aswinayyappadas.customer.IInterestRateProvider;
import com.aswinayyappadas.customer.ITransactionProvider;
import com.aswinayyappadas.personaldetails.PersonalDetails;
import java.util.UUID;
import java.util.List;

public class SavingsAccountCustomer extends PersonalDetails implements ICustomerAccount, IInterestRateProvider {
    private double balance;
    private final List<Double> transactionList;
    private final ICustomerAccount withdrawOperation;
    private final ICustomerAccount viewBalanceOperation;
    private final ICustomerAccount depositOperation;
    private final ICustomerAccount showTransactionsOperation;
    private final Admin admin;
    private final ITransactionProvider transactionProvider;
    private String accountNumber;

    public Double getBalance() {
        return this.balance;
    }

    public SavingsAccountCustomer(List<Double> transactionList,
                                  ICustomerAccount withdrawOperation,
                                  ICustomerAccount viewBalanceOperation,
                                  ICustomerAccount depositOperation,
                                  ICustomerAccount showTransactionsOperation,
                                  Admin admin, ITransactionProvider transactionProvider) {
        this.admin = admin;
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
        this.balance =  withdrawOperation.withdraw(amount, this.balance);
        transactionProvider.getTransactionMap().put(this.getAccountNumber(), this.getTransactionList());
        return 0.0;
    }

    @Override
    public double deposit(double amount, double balance) {
        this.balance =  depositOperation.deposit(amount, this.balance);
        transactionProvider.getTransactionMap().put(this.getAccountNumber(), this.getTransactionList());
        return 0.0;
    }

    @Override
    public void checkBalance(double balance) {
        viewBalanceOperation.checkBalance(this.balance);
    }

    @Override
    public void showTransactions() {
        showTransactionsOperation.showTransactions();
    }

    @Override
    public double getInterestRate() {
        return admin.getInterestRate();
    }
}
