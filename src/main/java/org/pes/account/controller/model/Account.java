package org.pes.account.controller.model;

public class Account {
    private String accountNumber;
    private String accountType;

    public static boolean validate(String accountNumber) throws Exception {
        if(accountNumber.length() == 11 && accountNumber.matches("\\d+")){
            return true;
        }

        throw new Exception("Not a valid account number");
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
