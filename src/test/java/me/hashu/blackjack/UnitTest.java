package me.hashu.blackjack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@SpringBootTest
class UnitTest {

    @Test
    @DisplayName("check the getSum() method of Hand class")
    void checkHandSum() {
        Hand hand = new Hand();
        hand.addCard(new Card(Rank.QUEEN, Suit.HEART));
        hand.addCard(new Card(Rank.TEN, Suit.SPADE));
        hand.addCard(new Card(Rank.ACE, Suit.DIAMOND));
        hand.addCard(new Card(Rank.SEVEN, Suit.CLUB));

        assertThat(hand.getSum()).isEqualTo(28);
    }

}
