package me.hashu.blackjack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class Blackjack {
    private Map<String, Hand> playerHands;

    public void start() {
        try {
            String[] playerNames = getPlayerNames();
            initializeHands(playerNames);
            dealCards();
            printCards();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void printCards() {
        for (Map.Entry<String, Hand> entry : playerHands.entrySet()) {
            System.out.println(entry.getKey());
            for (Card card : entry.getValue().getCards()) {
                System.out.println(card);
            }
            System.out.println("**************************************************");
        }
    }

    private String[] getPlayerNames() {
        Scanner scanner = new Scanner(System.in);
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

    private void dealCards() {
        for (String key : playerHands.keySet()) {
            playerHands.get(key).addCard(Card.getRandomCard());
            playerHands.get(key).addCard(Card.getRandomCard());
        }
    }
}
