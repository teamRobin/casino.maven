package com.github.zipcodewilmington.casino.games.keno;

import com.github.zipcodewilmington.casino.CasinoAccount;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class KenoPlayerTest {

    @Test
    public void constructorTest() {
        // Given
        CasinoAccount expectedCasinoAccount = new CasinoAccount("Zach", "Kitto", 22, 2000);
        CasinoAccount expectedCasinoAccount2 = new CasinoAccount("Mack", "Kitto", 22, 2000);
        KenoGame kenoGame = new KenoGame();
        KenoPlayer kenoPlayer = new KenoPlayer(expectedCasinoAccount, kenoGame);

        // When
        CasinoAccount actualCasinoAccount = kenoPlayer.getArcadeAccount();
        kenoPlayer.setArcadeAccount(expectedCasinoAccount2);
        CasinoAccount actualCasinoAccount2 = kenoPlayer.getArcadeAccount();

        // Then
        Assert.assertEquals(expectedCasinoAccount, actualCasinoAccount);
        Assert.assertEquals(expectedCasinoAccount2, actualCasinoAccount2);
    }

    @Test
    public void checkHowManyMatchTest() {
        // Given
        CasinoAccount casinoAccount1 = new CasinoAccount("Zach", "Kitto", 22, 2000);
        CasinoAccount casinoAccount2 = new CasinoAccount("Mack", "Kitto", 22, 2000);
        KenoGame kenoGame = new KenoGame();
        KenoPlayer kenoPlayer = new KenoPlayer(casinoAccount1, kenoGame);

        // When
        kenoPlayer.chosenNumbers = kenoGame.generateRandomNumbers();
        Integer numberOfMatches = kenoPlayer.checkHowManyMatch();

        // Then
        Assert.assertTrue(numberOfMatches >= 0 && numberOfMatches <= 10);
    }

    @Test
    public void outcomeOfGameTest() {
        // Given
        CasinoAccount casinoAccount1 = new CasinoAccount("Zach", "Kitto", 22, 2000);
        CasinoAccount casinoAccount2 = new CasinoAccount("Mack", "Kitto", 22, 2000);
        KenoGame kenoGame = new KenoGame();
        KenoPlayer kenoPlayer = new KenoPlayer(casinoAccount1, kenoGame);

        // When
        kenoPlayer.chosenNumbers = kenoGame.generateRandomNumbers();
        kenoPlayer.checkHowManyMatch();
        Integer prizeMoney = kenoPlayer.outcomeOfGame(1);

        // Then
        Assert.assertTrue(prizeMoney >= 0 && prizeMoney <= 100000);
    }
}
