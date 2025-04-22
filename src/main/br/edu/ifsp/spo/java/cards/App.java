package br.edu.ifsp.spo.java.cards;

import br.edu.ifsp.spo.java.cards.core.Game;
import br.edu.ifsp.spo.java.cards.ui.TerminalGameUI;

public class App {

    public static void main(String[] args) {
        var vinteUm = new Game(new TerminalGameUI());

        vinteUm.play();
    }
}