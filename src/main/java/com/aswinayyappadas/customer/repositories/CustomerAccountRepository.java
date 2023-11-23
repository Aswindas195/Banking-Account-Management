package com.aswinayyappadas.customer.repositories;

import com.aswinayyappadas.customer.ICustomerAccount;

import java.util.List;

public class CustomerAccountRepository {
    /**
        * Creating an array list to store customer accounts objects.
        * The internal state of the class is encapsulated by making the customerAccountList field private.
    */
    private final List<ICustomerAccount> customerAccountList;
    /**
        * Constructor for dependency injection
        * @param customerAccountList the list containing all customers.
        * Dependency injection is used in the constructor to provide flexibility in initializing the customerAccountList.
    */
    public CustomerAccountRepository(List<ICustomerAccount> customerAccountList) {
        this.customerAccountList = customerAccountList;
    }
    /**
        * Creating a method to add a customer account object to an account list.
        * @param customerAccount an object of type ICustomerAccount interface implementing class.
     */
    public boolean addCustomer(ICustomerAccount customerAccount) {
        return customerAccountList.add(customerAccount);
    }
}
