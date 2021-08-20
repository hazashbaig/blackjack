package me.hashu.blackjack;

public class Card {
    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public static Card getRandomCard() {
        return new Card(Rank.getRandomRank(), Suit.getRandomSuit());
    }

    public String humanReadableFormat() {
        return String.format("%s of %ss", toTitleCase(rank.toString()), toTitleCase(suit.toString()));
    }

    private String toTitleCase(String word) {
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return String.format("{%s,%s}", rank, suit);
    }
}
