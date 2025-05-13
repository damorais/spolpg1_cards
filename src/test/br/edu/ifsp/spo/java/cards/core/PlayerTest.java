package br.edu.ifsp.spo.java.cards.core;

import br.edu.ifsp.spo.java.cards.items.Card;
import br.edu.ifsp.spo.java.cards.items.Rank;
import br.edu.ifsp.spo.java.cards.items.Suit;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test
    void receiveCardWhenHandIsEmpty() {
        //Setup
        var sampleCard = new Card(Suit.CLUBS, Rank.EIGHT);
        var player = new Player("Sample Player");
        assertEquals(0, player.getHand().size());

        //Execute
        player.receiveCard(sampleCard);

        //Assert
        assertEquals(1, player.getHand().size());
    }

    @Test
    void discardHandWhenHaveHand() {
        //Setup
        var cards = new ArrayList<>(Arrays.asList(
                new Card(Suit.CLUBS, Rank.EIGHT),
                new Card(Suit.HEARTS, Rank.QUEEN)
        ));

        var player = new Player("Sample Player");

        for(var card : cards)
            player.receiveCard(card);

        //Execute
        var discardedCards = player.discardHand();

        //Assert
        assertIterableEquals(cards, discardedCards);
    }

    @Test
    void discardHandWhenHandIsEmpty() {
        //Setup
        var player = new Player("Sample Player");

        //Execute
        var discardedCards = player.discardHand();

        //Assert
        assertEquals(0, discardedCards.size());
    }
}