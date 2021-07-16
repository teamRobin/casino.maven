package com.github.zipcodewilmington.casino.games;

import com.github.zipcodewilmington.casino.games.keno.KenoGame;
import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

public class RandomNumberGeneratorTest {

    @Test
    public void generateRandomNumbersTest() {
        // Given
        KenoGame kenoGame = new KenoGame();
        Integer expectedSizeOfSet = 20;

        // When
        Set<Integer> setOfNumbers = kenoGame.generateRandomNumbers();
        Integer actualSizeOfSet = setOfNumbers.size();

        // Then
        Assert.assertEquals(expectedSizeOfSet, actualSizeOfSet);
    }

    @Test
    public void generateRandomNumberTest() {
        // Given
        KenoGame kenoGame = new KenoGame();
        Integer minNumber = 1;
        Integer maxNumber = 80;

        // When
        Integer randomNumber = kenoGame.generateRandomNumber();

        // Then
        Assert.assertTrue(randomNumber >= minNumber && randomNumber <= maxNumber);
    }

    @Test
    public void constructorTest() {
        // Given
        Integer expectedMinNumber = 1;
        Integer expectedMaxNumber = 80;
        Integer expectedAmountOfNumbers = 20;

        // When
        KenoGame kenoGame = new KenoGame();
        Integer actualMinNumber = kenoGame.getMinNumber();
        Integer actualMaxNumber = kenoGame.getMaxNumber();
        Integer actualAmountOfNumbers = kenoGame.getAmountOfNumbers();

        // Then
        Assert.assertEquals(expectedMinNumber, actualMinNumber);
        Assert.assertEquals(expectedMaxNumber, actualMaxNumber);
        Assert.assertEquals(expectedAmountOfNumbers, actualAmountOfNumbers);
    }
}
