package me.hashu.blackjack;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

@Profile("!test")
@Component
public class Blackjack implements CommandLineRunner {
    @Override
    public void run(String... args) {
        try {
            String[] playerNames = getPlayerNames();
            Map<String, Hand> playerHands = initializeHands(playerNames);
            System.out.println(playerHands);
        } catch (Exception e) {
            System.out.println(e.getMessage());
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

    private Map<String, Hand> initializeHands(String[] playerNames) {
        Map<String, Hand> playerHands = new HashMap<>();
        for (String name : playerNames) {
            playerHands.put(name, new Hand());
        }
        playerHands.put("dealer", new Hand());
        return playerHands;
    }
}
