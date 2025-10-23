package com.pluralsight;

public class Player {
    private String name;
    private Hand hand;
    private boolean isDealer;

    public Player(String name, boolean isDealer) {
        this.name = name;
        this.isDealer = isDealer;
        this.hand = new Hand();
    }

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }

    public boolean isDealer() {
        return isDealer;
    }

    public int getHandValue() {
        return hand.getValue();
    }

    public void dealCard(Card card) {
        hand.Deal(card);
    }

    @Override
    public String toString() {
        return "Player " +
                "name='" + name + '\'' +
                ", isDealer=" + isDealer ;
    }
}
