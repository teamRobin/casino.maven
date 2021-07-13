package com.github.zipcodewilmington.casino.games.Blackjack;

import java.util.Collections;
import java.util.Stack;

public class Deck {
    Stack<Card> cardDeck = new Stack<>();


    public Deck() {
        for (FaceValueOfCard value : FaceValueOfCard.values()) {
            for (Suit cardSuit : Suit.values()) {


                    Card card = new Card(value, cardSuit);
                    this.cardDeck.add(card);
                }

            }
            Collections.shuffle(cardDeck);
        }

        public void shuffle(){
            Collections.shuffle(cardDeck);
        }

    }