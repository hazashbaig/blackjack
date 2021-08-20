package me.hashu.blackjack;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test")
@Component
public class Main implements CommandLineRunner {
    @Override
    public void run(String... args) {
        Blackjack game = new Blackjack();
        game.start();
    }
}
