package com.pluralsight;

import java.util.ArrayList;

public class BlackJackGameApp {
    public static void main(String[] args) {

        Deck deck = new Deck();
        deck.shuffle();

        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("Romell", false));
        players.add(new Player("Lewis", false));
        players.add(new Player("Jada", false));
        players.add(new Player("Martha", false));
        players.add(new Player("Malik", false));
        players.add(new Player("Craig", true));



        Hand hand1 = new Hand();
        // deal 5 cards
        for (int I = 0; I < 5; I++) {
            // get a card from the deck
            Card card = deck.deal();
            // deal that card to the hand
            hand1.Deal(card);
        }
        int handValue = hand1.getValue();
        System.out.println("This hand is worth " + handValue);
    }
}

