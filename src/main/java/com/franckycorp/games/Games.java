package com.franckycorp.games;

import com.franckycorp.controller.GameController;
import com.franckycorp.model.Deck;
import com.franckycorp.view.CommandLineView;

public class Games {

    public static void main(String[] args) {
//        GameController gc = new GameController(new Deck(), new View(), new HighCardGameEvaluator());
        GameController gc = new GameController(new Deck(), new CommandLineView(), new LowCardGameEvaluator());
        gc.run();
    }
}
