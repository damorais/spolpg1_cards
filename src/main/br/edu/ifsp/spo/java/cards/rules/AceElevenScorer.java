package br.edu.ifsp.spo.java.cards.rules;

import br.edu.ifsp.spo.java.cards.items.Card;

import java.util.List;

public class AceElevenScorer implements Scorer{

    @Override
    public int calculateScore(List<Card> cards) {
        var score = 0;

        for(Card card : cards){
            score += switch(card.getRank()){
                case ACE -> 11;
                case TWO -> 2;
                case THREE -> 3;
                case FOUR -> 4;
                case FIVE -> 5;
                case SIX -> 6;
                case SEVEN -> 7;
                case EIGHT -> 8;
                case NINE -> 9;
                case TEN, JACK, QUEEN, KING -> 10;
            };
        }

        return score;
    }
}
