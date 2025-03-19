package br.edu.ifsp.spo.java.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private final List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();

        for (var suit : Suit.values()) {
            for (var rank : Rank.values()) {
                this.cards.add(new Card(suit, rank));
            }
        }

        Collections.shuffle(this.cards);
    }

    public Card drawCard() {
        return this.cards.remove(0);
    }

    public int remainingCards() {
        return this.cards.size();
    }

    @Override
    public String toString() {
        return "Deck{" +
                "cards=" + cards +
                '}';
    }

    public List<Card> getCards() {
        return cards;
    }
}
