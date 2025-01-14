package com.github.zipcodewilmington.casino.games.CrapsGame;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.io.Console;

public class CrapsGame implements GameInterface {
    Dice dice = new Dice();
    int num1;
    int num2;
    boolean x;
IOConsole console = new IOConsole(AnsiColor.PURPLE);
        public int firstRoll() {
            num1 = dice.rollingTheDice();

            System.out.println("Your first roll is " + num1 + "!");
            return num1;
        }

        public int secondRoll() {
            num2 = dice.rollingTheDice();

            System.out.println("Your second roll is " + num2 + "!");
            return num2;
        }

        public boolean sumOfRoll(int num1, int num2) {
            boolean x;
            if (num1==7||num1==11){
                if(num2==7||num2==11)
                    return true; System.out.println("Cash Out! You've won!");}
            if(num1!=11&&num1!=7){
                if(num2!=11&&num2!=7)
                    return true;
            } System.out.println("Turn in your chips... Better luck next time!");return false;
        }
    public void playingTheGame() {
        num1 = dice.rollingTheDice();
        console.println("Your first roll is " + num1 + "!");

        num2 = dice.rollingTheDice();
        console.println("Your second roll is " + num2 + "!");

        if (num1==7||num1==11){
            if(num2==7||num2==11)
                console.println("Cash Out! You've won!");
        else if(num1!=11&&num1!=7){
            if(num2!=11&&num2!=7)
                console.println("Cash Out! You've won!");}
        }else {console.println("Turn in your chips... Better luck next time!"); }
        }

    @Override
    public void add(PlayerInterface player) {


    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {
        IOConsole console = new IOConsole(AnsiColor.PURPLE);
        int input = 0;
        CrapsGame craps = new CrapsGame();
        console.println("Welcome to the Craps Table!");
        input = console.getIntegerInput("Press 1 to roll or press 2 to quit");
        while(input==1) {
            craps.playingTheGame();
            input = console.getIntegerInput("Press 1 to roll or press 2 to quit");
            if (input == 2) {
                break;
            }
        }

        }

    }



