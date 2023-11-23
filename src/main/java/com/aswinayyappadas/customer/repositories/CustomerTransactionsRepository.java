package com.aswinayyappadas.customer.repositories;

import com.aswinayyappadas.customer.ICustomerAccount;
import com.aswinayyappadas.customer.ITransactionProvider;

import java.util.HashMap;
import java.util.List;

public class CustomerTransactionsRepository implements ITransactionProvider {
    public final HashMap<String, List<Double>> transactionMap;
    public CustomerTransactionsRepository(HashMap<String, List<Double>> transactionMap) {
        this.transactionMap = transactionMap;
    }
    public void addTransaction(ICustomerAccount customer) {
         transactionMap.put(customer.getAccountNumber(), customer.getTransactionList());
    }

    @Override
    public HashMap<String, List<Double>> getTransactionMap() {
        return transactionMap;
    }
}
