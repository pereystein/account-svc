package org.pes.account.controller;

import org.pes.account.controller.model.Account;
import org.pes.account.controller.model.Amount;
import org.pes.account.service.AccountService;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/account-balance/{account}")
    public String accountBalance(@PathVariable("account") String accountNumber) throws Exception {
        Account.validate(accountNumber);
        return accountService.getBalance(accountNumber);
    }

    @PostMapping("/create-account")
    public String createAccount(
            @RequestBody Account account
    ) throws Exception {
        if (Account.validate(account.getAccountNumber())) {
            accountService.createAccount(account);

            return "Account " + account.getAccountNumber() + " created";
        }

        return "";
    }

    @PostMapping(value = "/deposit/{account}")
    public String deposit(
            @PathVariable("account") String account,
            @RequestBody Amount amount
    ) throws Exception {
        Account.validate(account);
        accountService.deposit(amount, account);

        return "OK";
    }

    @PostMapping(value = "/withdrawal/{account}")
    public String withdrawal(
            @PathVariable("account") String account,
            @RequestBody Amount amount
    ) throws Exception {
        Account.validate(account);
        accountService.withdraw(amount, account);

        return "OK";
    }


}
