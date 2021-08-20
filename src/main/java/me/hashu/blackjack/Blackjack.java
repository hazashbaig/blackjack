package me.hashu.blackjack;

import java.util.*;

public class Blackjack {
    Scanner scanner = new Scanner(System.in);
    private Map<String, Hand> playerHands;

    public void start() {
        try {
            String[] playerNames = getPlayerNames();
            initializeHands(playerNames);
            dealTwoCards();
            printHands();
            serve();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void printHands() {
        for (Map.Entry<String, Hand> entry : playerHands.entrySet()) {
            String playerName = entry.getKey();
            Hand playerHand = entry.getValue();
            System.out.println(playerName);
            playerHand.printHand();
            System.out.println("\n**************************************************\n");
        }
    }

    private String[] getPlayerNames() {
        System.out.print("Enter Player names separated by space: ");
        String playerNamesInput = scanner.nextLine();
        String[] playerNames = playerNamesInput.split("\\W+");
        throwIfDealerFound(playerNames);
        throwIfDuplicateFound(playerNames);
        return playerNames;
    }

    private void throwIfDealerFound(String[] playerNames) {
        for (String name : playerNames) {
            if (name.equalsIgnoreCase("dealer")) {
                throw new IllegalArgumentException(String.format("Player name cannot be %s", name));
            }
        }
    }

    private void throwIfDuplicateFound(String[] playerNames) {
        HashSet<String> seen = new HashSet<>();
        for (String name : playerNames) {
            if (seen.contains(name)) {
                throw new IllegalArgumentException(String.format("Duplicate player names NOT allowed: '%s'", name));
            }
            seen.add(name);
        }
    }

    private void initializeHands(String[] playerNames) {
        Map<String, Hand> playerHands = new HashMap<>();
        for (String name : playerNames) {
            playerHands.put(name, new Hand());
        }
        playerHands.put("dealer", new Hand());
        this.playerHands = playerHands;
    }

    private void dealTwoCards() {
        for (String key : playerHands.keySet()) {
            playerHands.get(key).addCard(Card.getRandomCard());
            playerHands.get(key).addCard(Card.getRandomCard());
        }
    }

    private void serve() {
        for (Map.Entry<String, Hand> entry : playerHands.entrySet()) {
            String currentPlayerName = entry.getKey();
            Hand currentPlayerHand = entry.getValue();
            if (currentPlayerName.equals("dealer")) {
                continue;
            }
            System.out.println(currentPlayerName);
            while (!currentPlayerHand.isBusted() && hit()) {
                playerHands.get(currentPlayerName).addCard(Card.getRandomCard());
                printHands();
            }
        }
    }

    private boolean hit() {
        while (true) {
            System.out.print("Hit(h) / Stand(s) : ");
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("h")) {
                return true;
            }
            if (input.equals("s")) {
                return false;
            }
            System.out.println("Please type either 'h' or 's'");
        }
    }
}
