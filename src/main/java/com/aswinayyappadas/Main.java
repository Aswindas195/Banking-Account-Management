package com.aswinayyappadas;

import com.aswinayyappadas.admin.Admin;
import com.aswinayyappadas.admin.adminoperations.ViewCustomerTransactions;
import com.aswinayyappadas.customer.customeroperations.DepositAmount;
import com.aswinayyappadas.customer.customeroperations.ShowTransactions;
import com.aswinayyappadas.customer.customeroperations.ViewBalance;
import com.aswinayyappadas.customer.customeroperations.WithdrawAmount;
import com.aswinayyappadas.customer.repositories.CustomerAccountRepository;
import com.aswinayyappadas.customer.repositories.CustomerTransactionsRepository;
import com.aswinayyappadas.customer.ICustomerAccount;
import com.aswinayyappadas.customer.ITransactionProvider;
import com.aswinayyappadas.customer.checkingaccount.CheckingAccountCustomer;
import com.aswinayyappadas.customer.savingaccount.SavingsAccountCustomer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<ICustomerAccount> accountsList = new ArrayList<>();
        List<Double> transactionList1 = new ArrayList<>();
        List<Double> transactionList2 = new ArrayList<>();
        HashMap<String, List<Double>> transactionMap = new HashMap<>();
        ITransactionProvider transactionProvider = new CustomerTransactionsRepository(transactionMap);
        CustomerAccountRepository accountsRepository = new CustomerAccountRepository(accountsList);
        // Assuming you have instances of operations for checking account
        ICustomerAccount withdrawOperationChecking = new WithdrawAmount(transactionList1);
        ICustomerAccount viewBalanceOperationChecking = new ViewBalance(transactionList1);
        ICustomerAccount depositOperationChecking = new DepositAmount(transactionList1);
        ICustomerAccount showTransactionsOperationChecking = new ShowTransactions(transactionList1);
        Admin a = new Admin(transactionProvider);
        a.setInterestRate(9.63);
        CheckingAccountCustomer checkingAccountCustomer = new CheckingAccountCustomer(
                transactionList1,
                withdrawOperationChecking,
                viewBalanceOperationChecking,
                depositOperationChecking,
                showTransactionsOperationChecking,
                transactionProvider
        );
        System.out.println(checkingAccountCustomer.getAccountNumber());

        // Assuming you have instances of operations for savings account
        ICustomerAccount withdrawOperationSavings = new WithdrawAmount(transactionList2);
        ICustomerAccount viewBalanceOperationSavings = new ViewBalance(transactionList2);
        ICustomerAccount depositOperationSavings = new DepositAmount(transactionList2);
        ICustomerAccount showTransactionsOperationSavings = new ShowTransactions(transactionList2);

        SavingsAccountCustomer savingAccountCustomer = new SavingsAccountCustomer(
                transactionList2,
                withdrawOperationSavings,
                viewBalanceOperationSavings,
                depositOperationSavings,
                showTransactionsOperationSavings,
                a, transactionProvider
        );

        accountsRepository.addCustomer(savingAccountCustomer);
        accountsRepository.addCustomer(checkingAccountCustomer);

        ViewCustomerTransactions viewCustomerTransactions = new ViewCustomerTransactions(transactionProvider);
        List<Double> transactions = viewCustomerTransactions.viewTransactionByCustomer(checkingAccountCustomer);
        // Deposit 100 to the checking account
        checkingAccountCustomer.deposit(10000.04, checkingAccountCustomer.getBalance());
        checkingAccountCustomer.withdraw(99.54, checkingAccountCustomer.getBalance());
        checkingAccountCustomer.withdraw(90.84, checkingAccountCustomer.getBalance());
        checkingAccountCustomer.deposit(10000.04, checkingAccountCustomer.getBalance());
        checkingAccountCustomer.deposit(10500.04, checkingAccountCustomer.getBalance());
        checkingAccountCustomer.deposit(10000.04, checkingAccountCustomer.getBalance());
        checkingAccountCustomer.deposit(10000.04, checkingAccountCustomer.getBalance());
        checkingAccountCustomer.deposit(10000.04, checkingAccountCustomer.getBalance());
        checkingAccountCustomer.deposit(10000.04, checkingAccountCustomer.getBalance());
        checkingAccountCustomer.deposit(10000.04, checkingAccountCustomer.getBalance());
        savingAccountCustomer.deposit(12345.263, savingAccountCustomer.getBalance());
        savingAccountCustomer.checkBalance(savingAccountCustomer.getBalance());
        savingAccountCustomer.showTransactions();
        // Check balance and show transactions
        checkingAccountCustomer.checkBalance(checkingAccountCustomer.getBalance());
        checkingAccountCustomer.showTransactions();
        a.showCustomerTransactions();
        System.out.println("Interest rate = " + savingAccountCustomer.getInterestRate());

    }
}
