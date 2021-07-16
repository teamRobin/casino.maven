package com.github.zipcodewilmington.casino.games.numberguess;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.Random;

/**
 * Created by leon on 7/21/2020.
 */
public class NumberGuessGame implements GameInterface {
    public static void main(String[] args) {

    }

    Random random = new Random();
    IOConsole console = new IOConsole(AnsiColor.BLUE);
    CasinoAccount casinoAccount = new CasinoAccount();
    PlayerInterface player;
    int guessedNumber = 0;
    int randomNumberFromOneToOneHundred = random.nextInt(100) + 1;
    int input = 1;



    @Override
    public void add(PlayerInterface player) {
    this.player = player;
    }

    @Override
    public void remove(PlayerInterface player) {
    this.player = null;
    }

    @Override
    public void run() {
        while (input == 1) {
            console.print("Welcome to the Number Guessing Game" + "\n");
            console.print("You need 10 dollars to play" + "\n");
            input = console.getIntegerInput("Press 1 to play. Press 2 to quit");
            if(input != 1){
                break;
            }
            player.getArcadeAccount().reduceBalance(10);
            guessedNumber = console.getIntegerInput("Guess a number between 1 and 100");
            if(guessedNumber >= 1 && guessedNumber <= 100) {
                if (guessedNumber == randomNumberFromOneToOneHundred) {
                    System.out.println("The random number is: " + randomNumberFromOneToOneHundred + "\n" + "\n");
                    player.getArcadeAccount().addToBalance(100);
                    console.print("Whoa!!! You've won 100 dollars!");
                    console.print("Your new balance is: " + player.getArcadeAccount().getBalance());
                } else {
                    System.out.println("The random number is: " + randomNumberFromOneToOneHundred + "\n" + "\n");
                    console.print("Better luck next time...");
                    console.print("Your balance is: " + player.getArcadeAccount().getBalance() + "\n" + "\n");
                }
                break;
            }

        }
    }
}