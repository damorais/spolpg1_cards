package br.edu.ifsp.spo.java.cards.core;

public class PlayerAI extends Player {

    public PlayerAI() {
        super("HAL-9000");
    }

    public PlayerAction makeDecision(int currentScore) {
        return currentScore >= 18 ? PlayerAction.STAND : PlayerAction.HIT;
    }
}
