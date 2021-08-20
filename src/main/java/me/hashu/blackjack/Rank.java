package me.hashu.blackjack;

import java.util.Random;

public enum Rank {
    ACE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(10),
    QUEEN(10),
    KING(10);

    private final int value;
    private static final Random random = new Random();

    Rank(int value) {
        this.value = value;
    }

    public static Rank getRandomRank() {
        int randomIdx = random.nextInt(values().length);
        return values()[randomIdx];
    }

    public int getValue() {
        return value;
    }
}
