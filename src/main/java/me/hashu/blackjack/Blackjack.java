package me.hashu.blackjack;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Profile("!test")
@Component
public class Blackjack implements CommandLineRunner {
    @Override
    public void run(String... args) {
        String[] playerNames = getPlayerNames();
        Map<String, Hand> playerHands = initializeHands(playerNames);
        // TODO: finish making the game
    }

    private String[] getPlayerNames() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Player names separated by space: ");
        String playerNamesInput = scanner.nextLine();
        String[] playerNames = playerNamesInput.split("\\W+");
        for (String name : playerNames) {
            if (name.equals("dealer")) {
                throw new IllegalArgumentException("Player name cannot be 'dealer'");
            }
        }
        return playerNames;
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
