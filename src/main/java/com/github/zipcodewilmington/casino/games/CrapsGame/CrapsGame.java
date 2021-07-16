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
    public void firstRoll() {
        num1 = dice.rollingTheDice();
        console.println("Your first roll is " + num1 + "!");

        num2 = dice.rollingTheDice();
        boolean x;
        console.println("Your second roll is " + num2 + "!");

        if (num1==7||num1==11){
            if(num2==7||num2==11)
                x=true;
        if(num1!=11&&num1!=7){
            if(num2!=11&&num2!=7)
                x=true;console.println("Cash Out! You've won!");}
        }else {console.println("Turn in your chips... Better luck next time!"); x=false;}
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
        while(input==1){
            craps.firstRoll();

        break;}

        }

    }



