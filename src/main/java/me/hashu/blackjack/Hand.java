package me.hashu.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
        cards.add(card);
    }

    public int getSum() {
        return cards.stream()
                .map(Card::getRank)
                .map(Rank::getValue)
                .reduce(0, Integer::sum);
    }

    @Override
    public String toString() {
        return String.format("Hand%s", cards);
    }
}
