package com.franckycorp;

import com.franckycorp.controller.GameController;
import com.franckycorp.games.HighCardGameEvaluator;
import com.franckycorp.view.GameSwingPassiveView;
import com.franckycorp.view.GameSwingView;
import com.franckycorp.view.GameViewables;

public class Games {

    public static void main(String[] args) {

        GameViewables views = new GameViewables();

        GameSwingView gsv = new GameSwingView();
        gsv.createAndShowGUI();

        views.addViewable(gsv);

        for (int i = 0; i < 3; i++) {
            GameSwingPassiveView passiveView = new GameSwingPassiveView();
            passiveView.createAndShowGUI();

            views.addViewable(passiveView);

            // Sleep
            try {
            Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        GameController gc = new GameController(DeckFactory.makeDeck(DeckFactory.DeckType.Normal), views, new HighCardGameEvaluator());
//        GameController gc = new GameController(new Deck(), gsv, new LowCardGameEvaluator());
        gc.run();
    }
}
