package com.github.zipcodewilmington.casino.games.Blackjack;

public class Card{
    FaceValueOfCard faceValueOfCard;
    Suit suit;

    public Card(FaceValueOfCard value, Suit suit){
        this.faceValueOfCard=value;
        this.suit=suit;
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
    public String getFaceValueAndSuit() {
        StringBuilder sb = new StringBuilder();
        sb.append(faceValueOfCard+"-"+suit);
        sb.append("\n");
        return sb.toString();
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }
//    public String toString() {
//
//        String suitCard = "";
//
//        //return String.format("%s of %s \n\n", rank, suit.toString().toLowerCase());
//        switch (suit.toString())
//        {
//            case "Heart":
//                suitCard = "♡";
//                break;
//            case "Diamond":
//                suitCard = "♢";
//                break;
//            case "Club":
//                suitCard = "♣";
//                break;
//            case "Spade":
//                suitCard = "♠";
//                break;
//        }
//
//        return String.format("%s %s \n", suit, suitCard);
//    }
}

