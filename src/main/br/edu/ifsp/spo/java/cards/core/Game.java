package br.edu.ifsp.spo.java.cards.core;

import br.edu.ifsp.spo.java.cards.items.Deck;
import br.edu.ifsp.spo.java.cards.rules.BasicScorer;
import br.edu.ifsp.spo.java.cards.rules.Scorer;
import br.edu.ifsp.spo.java.cards.ui.GameUI;

public class Game {

    private Player player1;
    private Player player2;

    private Deck deck;

    private Scorer scorer;

    private GameUI ui;

    public Game(GameUI gameUI){
        this.ui = gameUI;
        this.initialize();
    }

    private void initialize(){
        this.player1 = new Player(ui.requestPlayerName(1));
        this.player2 = new Player(ui.requestPlayerName(2));

        this.scorer = new BasicScorer(); //Deve vir da seleção do jogador
        this.scorer = ui.requestGameMode();

        this.deck = new Deck();

        this.player1.receiveCard(this.deck.drawCard());
        this.player1.receiveCard(this.deck.drawCard());

        this.player2.receiveCard(this.deck.drawCard());
        this.player2.receiveCard(this.deck.drawCard());
    }

    public void play(){

    }

    @Override
    public String toString(){
        var result = "Game - 21!";

        result += "\n\nPlayers:\n";
        result += "\n" + this.player1.toString();
        result += "\nPontuação do jogador 1: " + this.scorer.calculateScore(this.player1.getHand());
        result += "\n" + this.player2.toString();
        result += "\n\nRemaining cards:" + this.deck.remainingCards();
        result += "\nPontuação do jogador 2: " + this.scorer.calculateScore(this.player2.getHand());

        return result;
    }
}
