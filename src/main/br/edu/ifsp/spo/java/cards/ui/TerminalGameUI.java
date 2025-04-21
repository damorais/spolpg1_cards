package br.edu.ifsp.spo.java.cards.ui;


import br.edu.ifsp.spo.java.cards.rules.AceElevenScorer;
import br.edu.ifsp.spo.java.cards.rules.BasicScorer;
import br.edu.ifsp.spo.java.cards.rules.Scorer;

import java.util.Scanner;

public class TerminalGameUI implements GameUI {
    @Override
    public String requestPlayerName(int playerNumber) {
        var scanner = new Scanner(System.in);

        System.out.println("Insira o nome do jogador " + playerNumber + ":");

        return scanner.nextLine();
    }

    @Override
    public Scorer requestGameMode() {
        System.out.println("Escolha o modo de jogo:");
        System.out.println("(1) Para o modo clássico");
        System.out.println("(2) Para o modo \"Ás vale 11\"");

        var scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        Scorer scorer;
        switch (option) {
            case 1 -> scorer = new BasicScorer();
            case 2 -> scorer = new AceElevenScorer();
            default -> scorer = new BasicScorer();
        }

        return scorer;
    }
}
