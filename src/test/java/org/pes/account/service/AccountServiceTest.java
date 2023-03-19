package org.pes.account.service;

import org.junit.jupiter.api.Test;
import org.pes.account.controller.model.Amount;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceTest {

    @Test
    void testConversion() {
        Amount amount = new Amount();
        int unit = 13;
        int cent = 37;
        amount.setUnit(unit);
        amount.setCent(cent);
        Integer amountInCents = AccountService.amountInCents(amount);

        Assert.isTrue(amountInCents == 1337, "should be 1337, but is " + amountInCents);
    }
}