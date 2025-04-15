package br.edu.ifsp.spo.java.cards.rules;

import java.util.List;
import br.edu.ifsp.spo.java.cards.Card;

public interface Scorer {
    int calculateScore(List<Card> cards);
}
