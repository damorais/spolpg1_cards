package br.edu.ifsp.spo.java.cards.core;

import br.edu.ifsp.spo.java.cards.items.Deck;
import br.edu.ifsp.spo.java.cards.rules.BasicScorer;
import br.edu.ifsp.spo.java.cards.rules.Scorer;
import br.edu.ifsp.spo.java.cards.ui.GameUI;

import javax.swing.text.html.Option;
import java.util.Optional;

public class Game {

    private Player player1;
    private Player player2;

    private Deck deck;

    //Observe aqui que o atributo usa, como seu tipo, a interface "Scorer", ou seja, não há nenhuma menção a detalhes específicos
    //de funcionamento do mecanismo de pontuação. O cálculo da pontuação é feito de forma polimórfica, a partir do tipo de mecanismo
    //de pontuação selecionado pelo usuário (e tal objeto representando o mecanismo de pontuação vem a partir de uma seleção feita
    //na interface com o usuário - GameUI)
    private Scorer scorer;

    private GameUI ui;

    public Game(GameUI gameUI) {
        this.ui = gameUI;
        this.initialize();
    }

    private void initialize() {
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

    public void play() {
        Optional<Player> winner = Optional.empty();

        while(winner.isEmpty()){
            ui.renderGameStart();

            executeTurn(player1);
            executeTurn(player2);

            winner = this.resolveWinner();

            if(winner.isPresent()){
                //Apresento os resultados da partida
                System.out.println("O vencedor é:");
                System.out.println(winner.get());

            }else{
                //Reinicio o ciclo: Descarto as mãos, distribuo as cartas e começo de novo
                this.restart();
            }
        }



//        ui.renderStartTurn(this.player1.getName());
//
//        PlayerAction action;
//        do{
//            var currentScore = this.scorer.calculateScore(this.player1.getHand());
//            ui.renderHand(this.player1.getHand(), currentScore);
//
//            action = ui.requestAction();
//
//            if(action == PlayerAction.HIT)
//                this.player1.receiveCard(this.deck.drawCard());
//
//        } while(action == PlayerAction.HIT);
    }

    private void restart() {

        deck.addToDiscardPile(this.player2.discardHand());
        deck.addToDiscardPile(this.player2.discardHand());

        this.player1.receiveCard(this.deck.drawCard());
        this.player1.receiveCard(this.deck.drawCard());

        this.player2.receiveCard(this.deck.drawCard());
        this.player2.receiveCard(this.deck.drawCard());
    }

    private void executeTurn(Player player) {
        ui.renderStartTurn(player.getName());

        PlayerAction action = PlayerAction.STAND;

        do {
            var currentScore = this.scorer.calculateScore(player.getHand());

            ui.renderHand(player.getHand(), currentScore);

            action = getAction(currentScore);

            switch(action){
                case HIT -> player.receiveCard(this.deck.drawCard());
                case BUST -> ui.renderBusted(player.getName());
                case BLACKJACK -> ui.renderBlackjack(player.getName());
            };

        } while (action == PlayerAction.HIT);

        ui.renderEndTurn(player.getName());
    }

    private PlayerAction getAction(int score){
        if(score < 21)
            return ui.requestAction();
        else if(score > 21)
            return PlayerAction.BUST;
        else
            return PlayerAction.BLACKJACK;
    }

    private Optional<Player> resolveWinner(){
        var scorePlayer1 = this.scorer.calculateScore(this.player1.getHand());
        var scorePlayer2 = this.scorer.calculateScore(this.player2.getHand());

        var isDraw = (scorePlayer1 > 21 && scorePlayer2 > 21) || (scorePlayer1 == scorePlayer2);

        if (!isDraw){

            Optional<Player> winner = Optional.empty();

            if(scorePlayer1 > 21)
                winner = Optional.of(this.player2);
            else if (scorePlayer2 > 21)
                winner = Optional.of(this.player1);
            else
                winner = Optional.of(scorePlayer1 > scorePlayer2 ? this.player1 : this.player2);

            return winner;
        }
        else
            return Optional.empty();
    }


    @Override
    public String toString() {
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
