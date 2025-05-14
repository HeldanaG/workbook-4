package com.pluralsight;

public class Player {
    private String name;
    private Hand hand;

    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
    }

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }

    public void dealCard(Card card) {
        hand.deal(card);
    }

    public void revealHand() {
        for (Card card : hand.getCards()) {
            if (!card.isFaceUp()) card.flip();  // Flip face up
        }
    }

    public void displayHand() {
        System.out.println(name + "'s hand:");
        for (Card card : hand.getCards()) {
            System.out.println(" - " + card.getValue() + " of " + card.getSuit());
        }
        System.out.println("Total: " + hand.getValue());
        System.out.println();
    }
}
