package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.CardGame.BlackJack;
import com.github.zipcodewilmington.casino.games.CardGame.BlackJackPlayer;
import com.github.zipcodewilmington.casino.games.CardGame.CasinoWar;
import com.github.zipcodewilmington.casino.games.CardGame.CasinoWarPlayer;
import com.github.zipcodewilmington.casino.games.CrapsGame.CrapsGame;
import com.github.zipcodewilmington.casino.games.CrapsGame.CrapsPlayer;
import com.github.zipcodewilmington.casino.games.keno.KenoGame;
import com.github.zipcodewilmington.casino.games.keno.KenoPlayer;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessGame;
//import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessPlayer;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessPlayer;
import com.github.zipcodewilmington.casino.games.roulette.RouletteGame;
import com.github.zipcodewilmington.casino.games.roulette.RouletteGamePlayer;
import com.github.zipcodewilmington.casino.games.slots.SlotsGame;
//import com.github.zipcodewilmington.casino.games.slots.SlotsPlayer;
import com.github.zipcodewilmington.casino.games.slots.SlotsPlayer;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.*;

/**
 * Created by leon on 7/21/2020.
 */
public class Casino implements Runnable {
    private final IOConsole consoleBlue = new IOConsole(AnsiColor.BLUE);
    private final IOConsole consoleCyan = new IOConsole(AnsiColor.CYAN);
    private final IOConsole consoleRed = new IOConsole(AnsiColor.RED);


    @Override
    public void run() {
        CasinoAccountManager casinoAccountManager = new CasinoAccountManager();
        Integer arcadeDashBoardInput;
        printSign1();
        do {
            arcadeDashBoardInput = getArcadeDashboardInput();
            if (2 == arcadeDashBoardInput) {
                String accountName = consoleBlue.getStringInput("Enter your account name:");
                String accountPassword = consoleBlue.getStringInput("Enter your account password:");
                CasinoAccount casinoAccount = casinoAccountManager.getAccount(accountName, accountPassword);
                boolean isValidLogin = casinoAccount != null;
                if (isValidLogin) {

                    String gameSelectionInput = getGameSelectionInput().toUpperCase();

                    switch (gameSelectionInput) {
                        case "KENO":
                            while (isOldEnough(casinoAccount)) {
                                KenoGame kenoGame = new KenoGame();
                                play(kenoGame, new KenoPlayer(casinoAccount, kenoGame));
                                break;
                            }
                            break;

                        case "SLOTS":
                            while (isOldEnough(casinoAccount)) {
                                SlotsGame slotsGame = new SlotsGame();
                                play(slotsGame, new SlotsPlayer(casinoAccount));
                                break;
                            }
                            break;

                        case "BLACKJACK":
                            while (isOldEnough(casinoAccount)) {
                                BlackJack blackJack = new BlackJack();
                                play(blackJack, new BlackJackPlayer(casinoAccount));
                                break;
                            }
                            break;

                        case "NUMBERGUESS":
                            while (isOldEnough(casinoAccount)) {
                                NumberGuessGame numberGuessGame = new NumberGuessGame();
                                play(numberGuessGame, new NumberGuessPlayer(casinoAccount));
                                break;
                            }
                            break;

                        case "WAR":
                            new CasinoWar().playCasinoWarHands();
                            break;

                        case "ROULETTE":
                            while (isOldEnough(casinoAccount)) {
                                RouletteGame rouletteGame = new RouletteGame();
                                play(rouletteGame, new RouletteGamePlayer());
                                break;
                            }
                            break;

                        case "CRAPS":
                            while (isOldEnough(casinoAccount)) {
                                CrapsGame crapsGame = new CrapsGame();
                                play(crapsGame, new CrapsPlayer());
                                break;
                            }
                            break;

                        default:
                            consoleRed.println("[ %s ] is an invalid game selection", gameSelectionInput);

                    }
                } else {
                    consoleRed.println("No account found with name of [ %s ] and password of [ %s ]", accountName, accountPassword);
                }
            } else if (1 == arcadeDashBoardInput) {
                consoleBlue.println("Welcome to the account-creation screen.");
                String accountName = consoleBlue.getStringInput("Enter your account name:");
                String accountPassword = consoleBlue.getStringInput("Enter your account password:");
                Integer accountAge = consoleBlue.getIntegerInput("Enter your account age");
                Integer accountBalance = consoleBlue.getIntegerInput("Enter your account balance");
                CasinoAccount newAccount = casinoAccountManager.createAccount(accountName, accountPassword, accountAge, accountBalance);
                casinoAccountManager.registerAccount(newAccount);
            }
            else if (4 == arcadeDashBoardInput) {
                String accountName = consoleBlue.getStringInput("Enter your account name:");
                String accountPassword = consoleBlue.getStringInput("Enter your account password:");
                CasinoAccount casinoAccount = casinoAccountManager.getAccount(accountName, accountPassword);
                Integer amountToAdd = consoleBlue.getIntegerInput("Enter the amount to add to your balance");
                if (amountToAdd > 0) {
                    casinoAccount.addToBalance(amountToAdd);
                }
                else {
                    consoleRed.println("You entered an invalid amount");
                }
            }
        } while (3 != arcadeDashBoardInput);
    }

    private Integer getArcadeDashboardInput() {
        return consoleBlue.getIntegerInput(new StringBuilder()
                .append("Welcome to the Arcade Dashboard!")
                .append("\nFrom here, you can select any of the following options:")
                .append("\n\t1. create account  2. select game  3. logout  4. increase balance")
                .toString());
    }

    private String getGameSelectionInput() {
        return consoleBlue.getStringInput(new StringBuilder()
                .append("Welcome to the Game Selection Dashboard!")
                .append("\nFrom here, you can select any of the following options:")
                .append("\n\t[ SLOTS ], [ NUMBERGUESS ], [ KENO ], [ ROULETTE ]," +
                        "[ BLACKJACK ], [ WAR ], [ CRAPS ]")
                .toString());
    }

    private void play(Object gameObject, Object playerObject) {
        GameInterface game = (GameInterface)gameObject;
        PlayerInterface player = (PlayerInterface)playerObject;
        game.add(player);
        game.run();
    }

    private Boolean isOldEnough(CasinoAccount casinoAccount) {
        if (casinoAccount.getAge() < 18) {
            consoleRed.println("You are not old enough to play this game!");
            return false;
        }
        return true;
    }

    private void printSign() {
        StringBuilder builder = new StringBuilder();
        builder.append("♡ ♡ ♡ ♡ ♡               ♡          ♡                  ♡        ♡                             ♡ ♡ ♡ ♡ ♡    ♡    ♡                     ♡\n");
        builder.append("♡       ♡               ♡                               ♡    ♡                               ♡       ♡    ♡                          ♡\n");
        builder.append("♡ ♡ ♡ ♡ ♡    ♡ ♡ ♡ ♡    ♡ ♡ ♡ ♡    ♡    ♡ ♡ ♡ ♡           ♡♡    ♡ ♡ ♡ ♡    ♡     ♡           ♡ ♡ ♡ ♡      ♡    ♡    ♡ ♡ ♡ ♡    ♡ ♡ ♡ ♡\n");
        builder.append("♡     ♡      ♡     ♡    ♡     ♡    ♡    ♡     ♡           ♡♡    ♡     ♡    ♡     ♡           ♡       ♡    ♡    ♡    ♡     ♡    ♡     ♡\n");
        builder.append("♡       ♡    ♡ ♡ ♡ ♡    ♡ ♡ ♡ ♡    ♡    ♡     ♡           ♡♡    ♡ ♡ ♡ ♡    ♡ ♡ ♡ ♡           ♡ ♡ ♡ ♡ ♡    ♡    ♡    ♡     ♡    ♡ ♡ ♡ ♡\n");
        consoleCyan.println(builder.toString());
    }

    private void printSign1() {
        StringBuilder builder = new StringBuilder();
        builder.append("♠ ♠ ♠ ♠ ♠               ♠          ♠                  ♠        ♠                             ♠ ♠ ♠ ♠ ♠    ♠    ♠                     ♠\n");
        builder.append("♠       ♠               ♠                               ♠    ♠                               ♠       ♠    ♠                          ♠\n");
        builder.append("♠ ♠ ♠ ♠ ♠    ♠ ♠ ♠ ♠    ♠ ♠ ♠ ♠    ♠    ♠ ♠ ♠ ♠           ♠♠    ♠ ♠ ♠ ♠    ♠     ♠           ♠ ♠ ♠ ♠      ♠    ♠    ♠ ♠ ♠ ♠    ♠ ♠ ♠ ♠\n");
        builder.append("♠     ♠      ♠     ♠    ♠     ♠    ♠    ♠     ♠           ♠♠    ♠     ♠    ♠     ♠           ♠       ♠    ♠    ♠    ♠     ♠    ♠     ♠\n");
        builder.append("♠       ♠    ♠ ♠ ♠ ♠    ♠ ♠ ♠ ♠    ♠    ♠     ♠           ♠♠    ♠ ♠ ♠ ♠    ♠ ♠ ♠ ♠           ♠ ♠ ♠ ♠ ♠    ♠    ♠    ♠     ♠    ♠ ♠ ♠ ♠\n\n");
        builder.append("                                  ♠ ♠ ♠ ♠        ♠        ♠ ♠ ♠ ♠    ♠ ♠ ♠ ♠    ♠       ♠    ♠ ♠ ♠ ♠                          \n");
        builder.append("                                  ♠             ♠ ♠       ♠             ♠       ♠ ♠     ♠    ♠     ♠                          \n");
        builder.append("                                  ♠            ♠ ♠ ♠      ♠ ♠ ♠ ♠       ♠       ♠   ♠   ♠    ♠     ♠                          \n");
        builder.append("                                  ♠           ♠     ♠           ♠       ♠       ♠     ♠ ♠    ♠     ♠                          \n");
        builder.append("                                  ♠ ♠ ♠ ♠    ♠       ♠    ♠ ♠ ♠ ♠    ♠ ♠ ♠ ♠    ♠       ♠    ♠ ♠ ♠ ♠                          \n");
        consoleCyan.println(builder.toString());
    }
}