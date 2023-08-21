package com.franckycorp.view;

import com.franckycorp.controller.GameController;

public interface GameViewable {
    void setController(GameController gc);

    void promptForPlayerName();

    void promptForFlip();

    void promptForNewGame();

    void showPlayerName(int playerIndex, String playerName);

    void showFaceDownCardForPlayer(int playerIndex, String playerName);

    void showCardForPlayer(int i, String playerName, String rank, String suit);

    void showWinner(String playerName);
}
