package com.pluralsight;

import java.util.ArrayList;

public class BlackJackGameApp {
    public static void main(String[] args) {

        Deck deck = new Deck();
        deck.shuffle();

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

        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("Romell", false));
        players.add(new Player("Lewis", false));
        players.add(new Player("Jada", false));
        players.add(new Player("Martha", false));
        players.add(new Player("Malik", false));
        players.add(new Player("Craig", true));

        for (int dealcards = 0; dealcards < 2; dealcards++) {
            for (Player player : players) {
                player.dealCard(deck.deal());
            }
        }

        for (Player player : players) {
            if (player.isDealer()) continue;

            System.out.println("\n--- " + player.getName() + "'s Turn ---");
            System.out.println("Starting hand value: " + player.getHandValue());


            while (player.getHandValue() < 16) {
                System.out.println(player.getName() + " hits...");
                player.dealCard(deck.deal());
                System.out.println("New value: " + player.getHandValue());
            }
            System.out.println(player.getName() + " stands with: " + player.getHandValue());

        }
        Player dealer = players.get(players.size() - 1);
        System.out.println("\n---"+dealer.getName()+"'s Turn ---");

        while (dealer.getHandValue() < 17) {
            System.out.println("Dealer hits...");
            dealer.dealCard(deck.deal());
        }
        System.out.println("Dealer stands with: " + dealer.getHandValue());

        int dealerValue = dealer.getHandValue();

        for (Player player : players) {
            if (player.isDealer()) continue;

            int playerValue = player.getHandValue();
            System.out.println("\n" + player.getName() + ": " + playerValue);

            if (playerValue > 21) {
                System.out.println("Loser " + player.getName() + " busts! Dealer wins!");
            } else if (dealerValue > 21 || playerValue > dealerValue) {
                System.out.println("Congrats " + player.getName() + " wins!");
            } else if (playerValue == dealerValue) {
                System.out.println("Welp " + player.getName() + " ties with dealer.");
            } else {
                System.out.println("HaHa Dealer wins against " + player.getName() + ".");
            }


        }
    }
}

