package com.github.zipcodewilmington.casino;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class CasinoAccountManagerTest {

    @Test
    public void getAccountTest() {
        // Given
        CasinoAccountManager casinoAccountManager = new CasinoAccountManager();
        casinoAccountManager.createAccount("Bob", "Billy", 50, 120);
        CasinoAccount expectedAccount = casinoAccountManager.createAccount("Zach", "Password", 22, 1000);

        // When
        CasinoAccount actualAccount = casinoAccountManager.getAccount("Zach", "Password");

        // Then
        Assert.assertEquals(expectedAccount, actualAccount);
    }

    @Test
    public void createAccountTest() {
        // Given
        CasinoAccountManager casinoAccountManager = new CasinoAccountManager();
        CasinoAccount expectedAccount = casinoAccountManager.createAccount("Bob", "Billy", 50, 120);

        // When
        CasinoAccount actualAccount = casinoAccountManager.getAccount("Bob", "Billy");

        // Then
        Assert.assertEquals(expectedAccount, actualAccount);
    }

    @Test
    public void registerAccountTest() {
        // Given
        CasinoAccountManager casinoAccountManager = new CasinoAccountManager();
        CasinoAccount casinoAccount = casinoAccountManager.createAccount("Bob", "Billy", 50, 120);
        Set<CasinoAccount> expectedAccounts = new HashSet<>(); expectedAccounts.add(casinoAccount);

        // When
        casinoAccountManager.registerAccount(casinoAccount);
        Set<CasinoAccount> actualAccounts = casinoAccountManager.getArcadeAccountList();

        // Then
        Assert.assertEquals(expectedAccounts, actualAccounts);
    }
}
