package com.franckycorp;

import com.franckycorp.controller.GameController;
import com.franckycorp.games.HighCardGameEvaluator;
import com.franckycorp.view.GameSwingView;

public class Games {

    public static void main(String[] args) {

        GameSwingView gsv = new GameSwingView();
        gsv.createAndShowGUI();

        GameController gc = new GameController(DeckFactory.makeDeck(DeckFactory.DeckType.Normal), gsv, new HighCardGameEvaluator());
//        GameController gc = new GameController(new Deck(), gsv, new LowCardGameEvaluator());
        gc.run();
    }
}
