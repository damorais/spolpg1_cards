package br.edu.ifsp.spo.java.cards.ui;

import br.edu.ifsp.spo.java.cards.core.PlayerAction;
import br.edu.ifsp.spo.java.cards.items.Card;
import br.edu.ifsp.spo.java.cards.rules.Scorer;

import java.util.List;

public interface GameUI {
    String requestPlayerName(int playerNumber);

    Scorer requestGameMode();

    void renderHand(List<Card> cards, int score);

    PlayerAction requestAction();
}
