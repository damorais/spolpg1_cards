package br.edu.ifsp.spo.java.cards.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerAITest {


    @Test
    void makeDecisionWhenLesserThan18() {

        //Setup
        var ia = new PlayerAI();

        //Execute
        var action = ia.makeDecision(17);

        //Assert
        assertEquals(PlayerAction.HIT, action);
    }

    @Test
    void makeDecisionWhenEquals18() {

        //Setup
        var ia = new PlayerAI();

        //Execute
        var action = ia.makeDecision(18);

        //Assert
        assertEquals(PlayerAction.STAND, action);
    }

    @Test
    void makeDecisionWhenAbove18() {

        //Setup
        var ia = new PlayerAI();

        //Execute
        var action = ia.makeDecision(19);

        //Assert
        assertEquals(PlayerAction.STAND, action);
    }
}