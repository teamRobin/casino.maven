package com.github.zipcodewilmington.casino.games.Blackjack;

public class Card{
    FaceValueOfCard faceValueOfCard;
    Suit suit;

    public Card(FaceValueOfCard value, Suit symbol){
        this.faceValueOfCard=value;
        this.suit=symbol;
    }

    public FaceValueOfCard getFaceValueOfCard() {
        return faceValueOfCard;
    }

    public void setFaceValueOfCard(FaceValueOfCard faceValueOfCard) {
        this.faceValueOfCard = faceValueOfCard;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }
}
