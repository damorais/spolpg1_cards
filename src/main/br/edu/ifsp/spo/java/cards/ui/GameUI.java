package br.edu.ifsp.spo.java.cards.ui;

import br.edu.ifsp.spo.java.cards.rules.Scorer;

public interface GameUI {
    String requestPlayerName(int playerNumber);

    Scorer requestGameMode();
}
