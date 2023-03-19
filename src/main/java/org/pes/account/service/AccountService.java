package org.pes.account.service;

import org.pes.account.controller.model.Account;
import org.pes.account.controller.model.Amount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping("/api")
public class AccountService {

    private DbService dbService;

    @Autowired
    public AccountService(DbService dbService) {
        this.dbService = dbService;
    }

    public String getBalance(String accountNumber) {
        Double balance = dbService.getBalance(accountNumber) / 100.0;

        return balance.toString();
    }

    public void createAccount(Account account) {
        dbService.createAccount(account);
    }

    public void deposit(Amount amount, String account) {
        Integer amountInCents = amountInCents(amount);
        dbService.updateAccount(account, amountInCents);
    }


    public void withdraw(Amount amount, String account) {
        Integer amountInCents = -amountInCents(amount);
        dbService.updateAccount(account, amountInCents);
    }
    protected static Integer amountInCents(Amount amount) {
        Integer amountInCents = amount.getCent();
        amountInCents += amount.getUnit() * 100;

        return amountInCents;
    }
}
