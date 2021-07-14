package com.github.zipcodewilmington.casino.games.Blackjack;

import java.util.ArrayList;
import java.util.Comparator;

public class CardHand {
    ArrayList<Card> userHand = new ArrayList<Card>();


    public CardHand(ArrayList<Card> dealtCards){

        userHand.addAll(dealtCards);
    }

    public String displayHand() {

        userHand.sort(Comparator.comparing(Card::getFaceValueOfCard));
        StringBuilder sb = new StringBuilder();
        for (Card card:userHand
        ) { sb.append(card.getFaceValueAndSuit());
        }
//       for(int i = 0;i< userHand.size();i++)
//       {
//           sb.append(userHand.get(i).getFaceValueAndSuit());
//       }
//        return userHand.toString().replace(",", "")
//                .replace("[", " ").replace("]", "");
        return sb.toString();
    }

//    public String getOneHand() {
//
//        userHand.sort(Comparator.comparing(Card::getFaceValueOfCard));
//
//        return userHand.toString().replace(",", "")
//                .replace("[", " ").replace("]", "");
//    }

}

