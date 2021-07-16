package com.github.zipcodewilmington.casino.games.keno;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.RandomNumberGenerator;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.HashSet;
import java.util.Set;

public class KenoGame extends RandomNumberGenerator implements GameInterface {

    IOConsole console = new IOConsole(AnsiColor.BLUE);
    IOConsole consoleGreen = new IOConsole(AnsiColor.GREEN);
    IOConsole consoleRed = new IOConsole(AnsiColor.RED);
    Set<Integer> randomNumbers = generateRandomNumbers();
    Integer playerNumber = 1;
    KenoPlayer player;

    public KenoGame() {
        super(1,80, 20);
    }

    @Override
    public void add(PlayerInterface player) {
        this.player = (KenoPlayer)player;
    }

    @Override
    public void remove(PlayerInterface player) {
        this.player = null;
    }

    @Override
    public void run() {
        if (player.casinoAccount.getBalance() == 0) {
            consoleRed.println("You do not have enough money to play");
        }
        else {
            greeting();
            player.play();
            console.println("Your chosen numbers:  %s", player.chosenNumbers);
            player.outcomeOfGame(player.amountToBet);
            player.casinoAccount.addToBalance(player.prizeMoney);
            consoleGreen.println("Your new balance is $%s", player.casinoAccount.getBalance());
            console.println("Keno Board: %s", randomNumbers);
        }
    }

    public Set<Integer> getChosenNumbers() {
        Integer count = 1;
        Set<Integer> chosenNumbers = new HashSet<>();
        console.println("Input 10 numbers between 1 and 80");
        while (chosenNumbers.size() < 10) {
            Integer numberInput = console.getIntegerInput("Your chosen numbers: %s\nInput number #%s", chosenNumbers, count);
            if (chosenNumbers.contains(numberInput)) {
                console.println("Number has already been chosen");
            }
            else if (numberInput < 1 || numberInput > 80) {
                console.println("That is not a valid number to chose");
            }
            else {
                chosenNumbers.add(numberInput);
                count++;
            }
        }
        playerNumber++;
        return chosenNumbers;
    }

    public String greeting() {
        String output = new StringBuilder()
        .append("______________________________________________\n")
        .append("<<<<<<         Y O U   A R E            >>>>>>\n")
        .append("<<<<<<         P L A Y I N G            >>>>>>\n")
        .append("<<<<<<            K I N O               >>>>>>\n")
        .append("______________________________________________\n")
        .toString();
        consoleRed.println(output);
        return output;
    }
}
