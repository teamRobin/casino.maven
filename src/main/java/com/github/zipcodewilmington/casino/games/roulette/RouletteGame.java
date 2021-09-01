package com.github.zipcodewilmington.casino.games.roulette;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.Arrays;
import java.util.List;

public class RouletteGame implements GameInterface {
    int ball;
    Integer[] red;
    Integer[] black;
    int money;
    int bet;
    int input;
    int block;
    private PlayerInterface player;

    public RouletteGame() {
        ball = (int) (Math.random() * 36 + 1);
        red = new Integer[]{1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};
        black = new Integer[]{2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35};
        input = 0;
    }

    public void bettingOnRed(int block, int bet) {
        Ball game = new Ball();
        List<Integer> redNum = Arrays.asList(red);
        IOConsole console = new IOConsole(AnsiColor.YELLOW);
        if (block == 1) {
            game.ballColor(ball);
            if (redNum.contains(ball)) {
                money = bet * 2;
                console.println("Yay, you won $$$" + money + "!!!!");
            } else {
                money = bet - bet;
                console.println("Sorry you lost $" + bet + "!!!!");
            }
        }
    }

    public void bettingOnBlack(int block, int bet) {
        Ball game = new Ball();
        IOConsole console = new IOConsole(AnsiColor.YELLOW);
        if (block == 2) {
            List<Integer> blackNum = Arrays.asList(black);
            if (block == 2) {
                game.ballColor(ball);
                if (blackNum.contains(ball)) {
                    money = bet + bet;
                    console.println("Yay, you won $$$" + money + "!!!!");
                } else {
                    money = bet - bet;
                    console.println("Sorry you lost $" + bet + "!!!!");
                }
            }
        }
    }

    public void bettingOnOdd(int block, int bet) {
        IOConsole console = new IOConsole(AnsiColor.YELLOW);
        Ball game = new Ball();
        if (block == 3) {
            game.ballColor(ball);
            if (ball % 2 == 0) {
                money = bet - bet;
                console.println("Sorry you lost $" + bet + "!!!!");
            } else {
                money = bet + bet;
                console.println("Yay, you won $$$" + money + "!!!!");
            }
        }
    }

    public void bettingOnEven(int block, int bet) {
        IOConsole console = new IOConsole(AnsiColor.YELLOW);
        Ball game = new Ball();
        if (block == 4) {
            game.ballColor(ball);
            if (ball % 2 == 0) {
                money = bet + bet;
                console.println("Yay, you won $$$" + money + "!!!!");
            } else {
                money = bet - bet;
                console.println("Sorry you lost $" + bet + "!!!!");
            }
        }
    }

    public int bettingOnANumber(int block, int bet) {
        IOConsole console = new IOConsole(AnsiColor.YELLOW);
        Ball game = new Ball();
        int num = 0;
        num = console.getIntegerInput("Pick a number between 1-36 that you would like to bet on!");
        game.ballColor(ball);
        if (ball == num) {
            money = bet + bet * 2;
            console.println("Yay, you won $$$" + money + "!!!!");
            player.getArcadeAccount().addToBalance(money);
        } else {
            money = bet - bet;
            console.println("Sorry you lost $" + bet + "!!!!");
        }
        return p;
    }

    public int choosingABet() {
        IOConsole console = new IOConsole(AnsiColor.YELLOW);
        console.println("Welcome to The Roulette Table!");
        this.input = console.getIntegerInput("Would you like to Play? 1.Yes 2.No");
        while (this.input == 1) {
            console.println("Make your bets below <3");
            this.bet = console.getIntegerInput("Bet 1, 5, or 10");
            this.block = console.getIntegerInput("1.(Red) 2.(Black) 3.(Odds) 4.(Evens) 5.(Specific Number)");
            Ball game = new Ball();
            List<Integer> redNum = Arrays.asList(red);
            if (block == 1) {
                game.ballColor(ball);
                if (redNum.contains(ball)) {
                    money = bet * 2;
                    console.println("Yay, you won $$$" + money + "!!!!");

                } else {
                    money = bet - bet;
                    console.println("Sorry you lost $" + bet + "!!!!");
                }
            } else if (block == 2) {
                List<Integer> blackNum = Arrays.asList(black);
                if (block == 2) {
                    game.ballColor(ball);
                    if (blackNum.contains(ball)) {
                        money = bet + bet;
                        console.println("Yay, you won $$$" + money + "!!!!");
                    } else {
                        money = bet - bet;
                        console.println("Sorry you lost $" + bet + "!!!!");
                    }
                }
            } else if (block == 3) {
                game.ballColor(ball);
                if (ball % 2 == 0) {
                    money = bet - bet;
                    console.println("Sorry you lost $" + bet + "!!!!");
                } else {
                    money = bet + bet;
                    console.println("Yay, you won $$$" + money + "!!!!");
                }
            } else if (block == 4) {
                game.ballColor(ball);
                if (ball % 2 == 0) {
                    money = bet + bet;
                    console.println("Yay, you won $$$" + money + "!!!!");
                } else {
                    money = bet - bet;
                    console.println("Sorry you lost $" + bet + "!!!!");
                }
            } else if (block == 5) {
                int num = 0;
                num = console.getIntegerInput("Pick a number between 1-36 that you would like to bet on!");
                game.ballColor(ball);
                if (ball == num) {
                    money = bet + bet * 2;
                    console.println("Yay, you won $$$" + money + "!!!!");
                } else {
                    money = bet - bet;
                    console.println("Sorry you lost $" + bet + "!!!!");
                }
            }
        }
        return money;
    }

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
        RouletteGame game = new RouletteGame();
        IOConsole console = new IOConsole(AnsiColor.YELLOW);
        RouletteGamePlayer player = new RouletteGamePlayer();
        int playerMoney = player.casinoAccount.getBalance();
        console.println("Welcome to The Roulette Table!");
        if (bet > playerMoney) {
            console.println("Sorry you need more money to play!");
        } else {
            input = console.getIntegerInput("Would you like to Play? 1.Yes 2.No");

            if (input == 1) {
                console.println("Make your bets below <3");
                this.bet = console.getIntegerInput("Bet Any Amount");
                this.block = console.getIntegerInput("1.(Red) 2.(Black) 3.(Odds) 4.(Evens) 5.(Specific Number)");
                if (block == 1) {
                    game.bettingOnRed(block, bet);
                } else if (block == 2) {
                    game.bettingOnBlack(block, bet);
                } else if (block == 3) {
                    game.bettingOnEven(block, bet);
                } else if (block == 4) {
                    game.bettingOnOdd(block, bet);
                } else if (block == 5) {
                    game.bettingOnANumber(block, bet);
                } else {
                    player.getArcadeAccount().addToBalance(money);
                }

            } else {

            }
        }
    }
}
