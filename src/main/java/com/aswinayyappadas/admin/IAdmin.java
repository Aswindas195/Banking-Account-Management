package com.aswinayyappadas.admin;

import com.aswinayyappadas.customer.ICustomerAccount;
import com.aswinayyappadas.customer.ITransactionProvider;

import java.util.HashMap;
import java.util.List;

public interface IAdmin extends ITransactionProvider {
    public double setInterestRate(double newInterestRate);
    void showCustomerTransactions();
}
