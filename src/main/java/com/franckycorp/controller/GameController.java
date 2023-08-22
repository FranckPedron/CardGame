package com.franckycorp.controller;

import com.franckycorp.games.GameEvaluator;
import com.franckycorp.model.*;
import com.franckycorp.view.GameViewable;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    enum GameState {
        AddingPlayers, CardsDealt, WinnerRevealed;
    }

    Deck deck;
    List<IPlayer> players;
    IPlayer winner;
    GameViewable view;

    GameState gameState;
    GameEvaluator evaluator;

    public GameController(Deck deck, GameViewable view, GameEvaluator evaluator) {
        this.deck = deck;
        this.view = view;
        this.players = new ArrayList<IPlayer>();
        this.gameState = GameState.AddingPlayers;
        this.evaluator = evaluator;
        view.setController(this);
    }

    public void run() {
        while (gameState == GameState.AddingPlayers) {
            view.promptForPlayerName();
        }

        switch (gameState) {
            case CardsDealt -> view.promptForFlip();
            case WinnerRevealed -> view.promptForNewGame();
        }
    }

    public void addPlayer(String playerName) {
        if (gameState == GameState.AddingPlayers) {
            players.add(new Player(playerName));
            view.showPlayerName(players.size(), playerName);
        }
    }

    public void startGame() {
        if (gameState != GameState.CardsDealt) {
            deck.shuffle();
            int playerIndex = 1;
            for (IPlayer IPlayer : players) {
                IPlayer.addCardToHand(deck.removeTopCard());
                view.showFaceDownCardForPlayer(playerIndex++, IPlayer.getName());
            }
            gameState = GameState.CardsDealt;
        }
        this.run();
    }

    public void flipCards() {
        int playerIndex = 1;
        for (IPlayer IPlayer : players) {
            PlayingCard pc = IPlayer.getCard(0);
            pc.flip();
            view.showCardForPlayer(playerIndex++, IPlayer.getName(), pc.getRank().toString(), pc.getSuit().toString());
        }

        evaluateWinner();
        displayWinner();
        rebuildDeck();
        gameState = GameState.WinnerRevealed;
        this.run();
    }

    void evaluateWinner() {
        winner = new WiningPlayer(evaluator.evaluateWinner(players));
    }

    void rebuildDeck() {
        for (IPlayer IPlayer : players) {
            deck.returnCardToDeck(IPlayer.removeCard());
        }
    }

    void displayWinner() {
        view.showWinner(winner.getName());
    }

    void exitGame() {
        System.exit(0);
    }

    public void nextAction(String nextChoice) {
        if ("+q".equals(nextChoice)) {
            exitGame();
        } else {
            startGame();
        }
    }
}
