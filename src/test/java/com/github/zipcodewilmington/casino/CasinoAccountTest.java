package com.github.zipcodewilmington.casino;

import org.junit.Assert;
import org.junit.Test;

public class CasinoAccountTest {

    @Test
    public void constructorTest() {
        // Given
        String expectedUsername = "Zach";
        String expectedPassword = "Password";
        Integer expectedAge = 22;
        Integer expectedBalance = 1000;
        CasinoAccount casinoAccount = new CasinoAccount(expectedUsername, expectedPassword, expectedAge, expectedBalance);

        // When
        String actualUsername = casinoAccount.getUsername();
        String actualPassword = casinoAccount.getPassword();
        Integer actualAge = casinoAccount.getAge();
        Integer actualBalance = casinoAccount.getBalance();

        // Then
        Assert.assertEquals(expectedUsername, actualUsername);
        Assert.assertEquals(expectedPassword, actualPassword);
        Assert.assertEquals(expectedAge, actualAge);
        Assert.assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void settersTest() {
        // Given
        String expectedUsername = "Bob";
        String expectedPassword = "Billybob";
        Integer expectedBalance = 100;
        CasinoAccount casinoAccount = new CasinoAccount("Zach", "Password", 22, 1000);

        // When
        casinoAccount.resetUsername(expectedUsername);
        casinoAccount.resetPassword(expectedPassword);
        casinoAccount.setBalance(expectedBalance);
        String actualUsername = casinoAccount.getUsername();
        String actualPassword = casinoAccount.getPassword();
        Integer actualBalance = casinoAccount.getBalance();

        // Then
        Assert.assertEquals(expectedUsername, actualUsername);
        Assert.assertEquals(expectedPassword, actualPassword);
        Assert.assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void addToBalanceTest() {
        // Given
        Integer expectedBalance = 100;
        CasinoAccount casinoAccount = new CasinoAccount("Zach", "Password", 22, 80);

        // When
        casinoAccount.addToBalance(20);
        Integer actualBalance = casinoAccount.getBalance();

        // Then
        Assert.assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void reduceBalanceTest() {
        // Given
        Integer expectedBalance = 100;
        CasinoAccount casinoAccount = new CasinoAccount("Zach", "Password", 22, 150);

        // When
        casinoAccount.reduceBalance(50);
        Integer actualBalance = casinoAccount.getBalance();

        // Then
        Assert.assertEquals(expectedBalance, actualBalance);
    }
}
