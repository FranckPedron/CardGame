package com.franckycorp.games;

import com.franckycorp.controller.GameController;
import com.franckycorp.model.Deck;
import com.franckycorp.view.View;

public class Games {

    public static void main(String[] args) {
//        GameController gc = new GameController(new Deck(), new View(), new HighCardGameEvaluator());
        GameController gc = new GameController(new Deck(), new View(), new LowCardGameEvaluator());
        gc.run();
    }
}
