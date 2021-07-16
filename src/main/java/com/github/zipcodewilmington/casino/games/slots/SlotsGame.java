package com.github.zipcodewilmington.casino.games.slots;

import com.fasterxml.jackson.databind.util.ISO8601Utils;
import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsGame implements GameInterface {
    CasinoAccount casinoAccount = new CasinoAccount();
    IOConsole console = new IOConsole(AnsiColor.BLUE);
    Random generator = new Random();
    String slot1, slot2, slot3;
    int input = 1;
    PlayerInterface slotsPlayer;

    @Override
    public void add(PlayerInterface player) {
        this.slotsPlayer = player;
    }

    @Override
    public void remove(PlayerInterface player) {
        this.slotsPlayer = null;
    }

    @Override
    public void run() {

        while(input == 1){

            if (slotsPlayer.getArcadeAccount().getBalance() <= 0){
                console.print("Sorry brokey... you need more money!" + "\n");
                break;
            }
            console.println("Welcome to the Slot Machine!");
            console.println("You need 5 dollars to play!" + "\n");
            input = console.getIntegerInput("Press 1 to pull or press 2 to quit");
            if(input == 2){
                break;
            }
            slotsPlayer.getArcadeAccount().reduceBalance(5);
            String[] slotValues = {"watermelon", "grape", "lemon", "orange", "bar", "7", "BIGWIN", "cherry","banana"};
            slot1 = slotValues[generator.nextInt(slotValues.length)];
            slot2 = slotValues[generator.nextInt(slotValues.length)];
            slot3 = slotValues[generator.nextInt(slotValues.length)];


            console.print(slot1 + " " + slot2 + " " + slot3 + "\n");

            if (slot1 == "BIG WIN" && slot1 == slot2 && slot1 == slot3) {
               console.print("Jackpot! You win 50 dollars!" + "\n");
                slotsPlayer.getArcadeAccount().addToBalance(50);
                console.print("New balance is: " + slotsPlayer.getArcadeAccount().getBalance().toString() + "\n" + "\n");
            } else if (slot1 == slot2 && slot1 == slot3) {
                console.print("Congrats! You win 10 dollars." + "\n");
                slotsPlayer.getArcadeAccount().addToBalance(10);
                console.print("New balance is: " + slotsPlayer.getArcadeAccount().getBalance().toString() + "\n" + "\n");
            } else if (slot1 == slot2 || slot1 == slot3 || slot2 == slot3) {
                console.print("Congrats! You win 5 dollars." + "\n");
                slotsPlayer.getArcadeAccount().addToBalance(5);
                console.print("New balance is: " + slotsPlayer.getArcadeAccount().getBalance().toString() + "\n" + "\n");
            } else {
                console.print("Sorry! Better luck next time." + "\n");
                console.print("Your balance is: " + slotsPlayer.getArcadeAccount().getBalance().toString() + "\n" + "\n");
            }

        }
    }
}
