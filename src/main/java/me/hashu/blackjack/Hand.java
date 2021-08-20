package me.hashu.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards = new ArrayList<>();
    private int totalSum;

    public void addCard(Card card) {
        cards.add(card);
        totalSum += card.getRank().getValue();
    }

    public int getTotalSum() {
        return totalSum;
    }

    public boolean isBusted() {
        return totalSum > 21;
    }

    public void printHand() {
        for (Card card : cards) {
            System.out.println(card.humanReadableFormat());
        }
        System.out.println("Total: " + getTotalSum());
        if (isBusted()) {
            System.out.println("BUSTED!");
        }
    }

    @Override
    public String toString() {
        return String.format("Hand%s", cards);
    }
}
