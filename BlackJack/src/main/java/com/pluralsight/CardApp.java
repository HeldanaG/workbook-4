package com.pluralsight;

import java.util.*;

public class CardApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Prompt for number of players
        System.out.print("Enter number of players: ");
        int numPlayers = Integer.parseInt(scanner.nextLine());

        ArrayList<Player> players = new ArrayList<>();

        // 2. Collect player names
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter player " + (i + 1) + " name: ");
            String name = scanner.nextLine();
            players.add(new Player(name));
        }

        // 3. Prepare deck
        Deck deck = new Deck();
        deck.shuffle();

        // 4. Deal 2 cards to each player
        for (Player player : players) {
            player.dealCard(deck.deal());
            player.dealCard(deck.deal());
            player.revealHand();
        }

        // 5. Display hands
        for (Player player : players) {
            player.displayHand();
        }

        // 6. Determine winner
        Player winner = null;
        int highest = 0;

        for (Player player : players) {
            int value = player.getHand().getValue();
            if (value > highest && value <= 21) {
                highest = value;
                winner = player;
            }
        }

        if (winner != null) {
            System.out.println("The winner is " + winner.getName() + " with " + highest + " points!");
        } else {
            System.out.println("No winner. All players busted.");
        }
    }
}
