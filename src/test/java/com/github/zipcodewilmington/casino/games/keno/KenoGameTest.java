package com.github.zipcodewilmington.casino.games.keno;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.RandomNumberGenerator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class KenoGameTest {

    @Test
    public void addTest() {
        // Given
        CasinoAccount casinoAccount = new CasinoAccount("Zach", "Kitto", 22, 2000);
        KenoGame kenoGame = new KenoGame();
        PlayerInterface expectedPlayer = new KenoPlayer(casinoAccount, kenoGame);

        // When
        kenoGame.add(expectedPlayer);
        PlayerInterface actualPlayer = kenoGame.player;

        // Then
        Assert.assertEquals(expectedPlayer, actualPlayer);
    }

    @Test
    public void removeTest() {
        // Given
        CasinoAccount casinoAccount1 = new CasinoAccount("Zach", "Kitto", 22, 2000);
        KenoGame kenoGame = new KenoGame();
        PlayerInterface player1 = new KenoPlayer(casinoAccount1, kenoGame);

        // When
        kenoGame.add(player1);
        kenoGame.remove(player1);

        // Then
        Assert.assertNull(kenoGame.player);
    }

    @Test
    public void greetingTest() {
        // Given
        String expectedOutput = new StringBuilder()
                .append("______________________________________________\n")
                .append("<<<<<<         Y O U   A R E            >>>>>>\n")
                .append("<<<<<<         P L A Y I N G            >>>>>>\n")
                .append("<<<<<<            K I N O               >>>>>>\n")
                .append("______________________________________________\n")
                .toString();

        // When
        KenoGame kenoGame = new KenoGame();
        String actualOutput = kenoGame.greeting();

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

//    @Test
//    public void runTest() {
//        // Given
//        CasinoAccount casinoAccount1 = new CasinoAccount("Zach", "Kitto", 22, 2000);
//        CasinoAccount casinoAccount2 = new CasinoAccount("Mack", "Kitto", 22, 2000);
//        KenoGame kenoGame = new KenoGame();
//        KenoPlayer player1 = new KenoPlayer(casinoAccount1, kenoGame);
//        KenoPlayer player2 = new KenoPlayer(casinoAccount2, kenoGame);
//        Integer expectedPlayer1SetOfNumbersSize = 10;
//        Integer expectedPlayer2SetOfNumbersSize = 10;
//
//        // When
//        kenoGame.add(player1);
//        kenoGame.add(player2);
//        kenoGame.run();
//        Integer actualPlayer1SetOfNumbersSize = player1.chosenNumbers.size();
//        Integer actualPlayer2SetOfNumbersSize = player2.chosenNumbers.size();
//
//        // Then
//        Assert.assertEquals(expectedPlayer1SetOfNumbersSize, actualPlayer1SetOfNumbersSize);
//        Assert.assertEquals(expectedPlayer2SetOfNumbersSize, actualPlayer2SetOfNumbersSize);
//    }
}
