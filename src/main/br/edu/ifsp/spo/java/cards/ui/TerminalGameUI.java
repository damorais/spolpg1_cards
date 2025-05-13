package br.edu.ifsp.spo.java.cards.ui;

import br.edu.ifsp.spo.java.cards.core.Player;
import br.edu.ifsp.spo.java.cards.core.PlayerAction;
import br.edu.ifsp.spo.java.cards.items.Card;
import br.edu.ifsp.spo.java.cards.rules.AceElevenScorer;
import br.edu.ifsp.spo.java.cards.rules.BasicScorer;
import br.edu.ifsp.spo.java.cards.rules.Scorer;

import java.util.List;
import java.util.Scanner;

public class TerminalGameUI implements GameUI {

    public static final String ANSI_CLS = "\u001b[2J";     // Limpar tela
    public static final String ANSI_HOME = "\u001b[H";      // Mover cursor para 0,0 (topo esquerdo)

    private static void clearScreen() {
        System.out.print(ANSI_CLS + ANSI_HOME);
        System.out.flush(); // Garante que os comandos sejam enviados imediatamente
    }

    @Override
    public String requestPlayerName(int playerNumber) {
        clearScreen();
        var scanner = new Scanner(System.in);

        System.out.println("Insira o nome do jogador " + playerNumber + ":");

        return scanner.nextLine();
    }

    @Override
    public Scorer requestGameMode() {
        clearScreen();
        System.out.println("Escolha o modo de jogo:");
        System.out.println("(1) Para o modo clássico");
        System.out.println("(2) Para o modo \"Ás vale 11\"");

        var scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        return switch (option) {
            case 1 -> new BasicScorer();
            case 2 -> new AceElevenScorer();
            default -> new BasicScorer();
        };
    }

    @Override
    public void renderGameStart() {
        clearScreen();
        System.out.println("Começando a partida...");
    }

    @Override
    public void renderStartTurn(String playerName) {
        System.out.println("Agora é a vez de " + playerName);
    }

    @Override
    public void renderHand(List<Card> hand, int score) {
        System.out.println("Sua mão atual é: ");
        for (Card card : hand) {
            System.out.println(card);
        }
        System.out.println("Sua pontuação atual é: " + score);
    }

    @Override
    public PlayerAction requestAction() {
        System.out.println("O que você deseja fazer?");

        System.out.println("(1) Comprar uma carta");
        System.out.println("(2) Manter a mão atual");

        var scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        return option == 1 ? PlayerAction.HIT : PlayerAction.STAND;
    }

    @Override
    public void renderBusted(String name) {
        System.out.println(name + " ESTOUROU!!!");
    }

    @Override
    public void renderBlackjack(String name) {
        System.out.println(name + " CONSEGUIU 21!!!");
    }

    @Override
    public void renderWinner(Player winner) {
        System.out.println("O vencedor é:");
        System.out.println(winner);
    }

    @Override
    public void renderEndTurn(String name) {
        System.out.println("Fim da vez de " + name);
    }
}
