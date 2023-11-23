package com.aswinayyappadas.customer.customeroperations;
import java.util.UUID;
public class AccountNumberGenerator {
    public static String generateAccountNumber() {
        UUID uuid = UUID.randomUUID();
        // Convert UUID to a string and remove hyphens to create a simple account number
        String accountNumber = uuid.toString().replace("-", "");
        return accountNumber;
    }

    public static void main(String[] args) {
        String randomAccountNumber = generateAccountNumber();
        System.out.println("Random Account Number: " + randomAccountNumber);
    }
}

