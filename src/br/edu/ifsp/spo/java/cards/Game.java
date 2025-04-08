package br.edu.ifsp.spo.java.cards;

public class Game {

    private Player player1;
    private Player player2;

    private Deck deck;

    public Game(){
        this.initialize();
    }

    private void initialize(){
        this.player1 = new Player("Ada Lovelace");
        this.player2 = new Player("Grace Hopper");

        this.deck = new Deck();

        this.player1.receiveCard(this.deck.drawCard());
        this.player1.receiveCard(this.deck.drawCard());

        this.player2.receiveCard(this.deck.drawCard());
        this.player2.receiveCard(this.deck.drawCard());
    }

    @Override
    public String toString(){
        var result = "Game - 21!";

        result += "\n\nPlayers:\n";
        result += "\n" + this.player1.toString();
        result += "\n" + this.player2.toString();
        result += "\n\nRemaining cards:" + this.deck.remainingCards();

        return result;
    }
}
