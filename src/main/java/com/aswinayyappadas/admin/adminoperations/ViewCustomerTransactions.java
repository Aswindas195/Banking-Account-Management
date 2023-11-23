package com.aswinayyappadas.admin.adminoperations;

import com.aswinayyappadas.admin.IAdmin;
import com.aswinayyappadas.customer.ICustomerAccount;
import com.aswinayyappadas.customer.ITransactionProvider;

import java.util.HashMap;
import java.util.List;

public class ViewCustomerTransactions implements ITransactionProvider {
    private final ITransactionProvider transactionsRepository;

    public ViewCustomerTransactions(ITransactionProvider transactionsRepository) {
        this.transactionsRepository = transactionsRepository;
    }

    public List<Double> viewTransactionByCustomer(ICustomerAccount customer) {
        return transactionsRepository.getTransactionMap().get(customer);
    }

    @Override
    public HashMap<String, List<Double>> getTransactionMap() {
        return transactionsRepository.getTransactionMap();
    }
}
