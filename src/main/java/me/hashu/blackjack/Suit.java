package me.hashu.blackjack;

import java.util.Random;

public enum Suit {
    DIAMOND,
    SPADE,
    CLUB,
    HEART;

    private static final Random random = new Random();

    public static Suit getRandomSuit() {
        int randomIdx = random.nextInt(values().length);
        return values()[randomIdx];
    }
}
