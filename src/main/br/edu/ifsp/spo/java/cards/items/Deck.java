package br.edu.ifsp.spo.java.cards.items;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private final List<Card> cards;
    private final List<Card> discardedCards;

    public Deck() {
        this.cards = new ArrayList<>();
        this.discardedCards = new ArrayList<>();

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

    public void addToDiscardPile(List<Card> cards) {
        this.discardedCards.addAll(cards);
    }
}
