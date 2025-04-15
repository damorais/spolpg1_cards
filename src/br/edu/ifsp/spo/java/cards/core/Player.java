package br.edu.ifsp.spo.java.cards.core;

import br.edu.ifsp.spo.java.cards.items.Card;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private List<Card> hand;

    public Player(String name) {
        this.hand = new ArrayList<>();
        this.name = name;
    }

    public void receiveCard(Card card) {
        this.hand.add(card);
    }

    @Override
    public String toString() {
        var result = "Player: " + this.getName();
        result += "\n- Current hand: ";

        for (var card : this.hand) {
            result += "\n-- " + card.toString();
        }

        return result;
    }

    private String getName() {
        return this.name;
    }
}
