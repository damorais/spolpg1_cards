package br.edu.ifsp.spo.java.cards.rules;

import br.edu.ifsp.spo.java.cards.items.Card;

import java.util.List;

public class BasicScorer implements Scorer {

    private int calculateScore(Card card){
        //Este é um exemplo de um switch usado como expression (expressão). Neste caso, o switch retorna algo, que pode ser atribuído
        //a uma variável ou, como é o caso, usado como retorno. Observe que se eu uso a sintaxe de switch como statement (declaração),
        // que é a maneira "clássica", eu não consigo fazer isso
        return switch (card.getRank()) {
            case ACE -> 1;
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

    @Override
    public int calculateScore(List<Card> cards) {
        //Aqui uma forma de escrever a interação em uma lista:
        // - a transformação dela em outra "coisa": map transforma cada item da lista em alguma outra coisa, no caso, o
        // resultado do método "calculateScore"
        // - Com o resultado do map (uma lista de inteiros), eu aplico a função "reduce" que, basicamente, aglutina a lista
        // seguindo como regra a função passada como parâmetro. Observe que reduce recebe dois parâmetros: o primeiro, identity,
        // representa o elemento neutro da operação, ou seja, qual o valor inicial da operação. O segundo, a operação que será
        // aplicada, no caso a soma de dois inteiros
        // A forma "expandida" do reduce seria algo assim: .reduce(0, (subtotal, element) -> subtotal + element)
        // Como é uma operação comum, o Java já possui o Integer::sum como forma de fazer isso
        return cards.stream().map(this::calculateScore).reduce(0, Integer::sum);
    }
}
