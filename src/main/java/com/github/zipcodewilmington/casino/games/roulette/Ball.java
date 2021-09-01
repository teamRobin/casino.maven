package com.github.zipcodewilmington.casino.games.roulette;

import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.Arrays;
import java.util.List;

public class Ball {
    int ball;
    Integer[] red;
    Integer[] black;
    int input;

    public Ball() {
        ball = (int) (Math.random() * 36 + 1);
        red = new Integer[]{1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};
        black = new Integer[]{2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35};
        input=0;
    }
    public void ballColor(int ball){
        IOConsole console = new IOConsole(AnsiColor.PURPLE);
        List<Integer> redNum = Arrays.asList(red);
        if (redNum.contains(ball)) {
            console.println("Number is "+ball+" RED!");
        }else{console.println("Number is "+ball+" BLACK!");
        }
    }
}
