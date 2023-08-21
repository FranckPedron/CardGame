package com.franckycorp.view;

import com.franckycorp.controller.GameController;

import java.util.Scanner;

public class CommandLineView implements GameViewable {

    GameController controller;
    Scanner keyboard = new Scanner(System.in);

    @Override
    public void setController(GameController gc) {
        this.controller = gc;
    }

    @Override
    public void promptForPlayerName() {
        System.out.println("Enter player name");
        String name = keyboard.nextLine();
        if (name.isEmpty()) {
            controller.startGame();
        } else {
            controller.addPlayer(name);
        }
    }

    @Override
    public void promptForFlip() {
        System.out.println("Press enter to reveal cards");
        keyboard.nextLine();
        controller.flipCards();
    }

    @Override
    public void promptForNewGame() {
        System.out.println("Press enter to deal again or +q to exit");
        controller.nextAction(keyboard.nextLine());
    }

    @Override
    public void showPlayerName(int playerIndex, String playerName) {
        System.out.println("[" + playerIndex + "]["+playerName+ "]");
    }

    @Override
    public void showFaceDownCardForPlayer(int playerIndex, String playerName) {
        System.out.println("["+playerIndex+"]["+playerName+"][x][x]" );
    }

    @Override
    public void showCardForPlayer(int i, String playerName, String rank, String suit) {
        System.out.println("["+i+"]["+playerName+"]["+rank+"]["+suit+"]");
    }

    @Override
    public void showWinner(String playerName) {
        System.out.println("Winner is " + playerName + " !");
    }
}
