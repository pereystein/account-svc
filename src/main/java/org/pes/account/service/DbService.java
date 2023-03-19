package org.pes.account.service;

import org.pes.account.controller.model.Account;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class DbService {
    private final HashMap<String, Integer> vault;

    public DbService() {
        this.vault = new HashMap<String, Integer>();

        // create dummy account
        this.vault.put("12345678903", 1337);
    }

    public int getBalance(String accountNumber) {
        Integer amount = vault.get(accountNumber);
        return amount;
    }

    public void createAccount(Account account) {
        this.vault.put(account.getAccountNumber(), 0);
    }

    public void updateAccount(String account, Integer change) {
        Integer currentBalance = vault.get(account);
        Integer newBalance = currentBalance + change;
        vault.put(account, newBalance);
    }
}
