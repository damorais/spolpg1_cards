package br.edu.ifsp.spo.java.cards;

import java.text.MessageFormat;

public class App {

    public static void main(String[] args) {

        Deck deck = new Deck();

        Card card = deck.drawCard();

        System.out.println(card);

        System.out.println(MessageFormat.format("Cartas restantes no baralho: {0}", deck.remainingCards()));
    }
}