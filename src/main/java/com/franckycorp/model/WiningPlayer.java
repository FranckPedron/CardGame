package com.franckycorp.model;

public class WiningPlayer implements IPlayer{

    IPlayer winner;

    public WiningPlayer(IPlayer player) {
        this.winner = player;
    }

    @Override
    public void addCardToHand(PlayingCard pc) {
        winner.addCardToHand(pc);
    }

    @Override
    public PlayingCard getCard(int index) {
        return winner.getCard(index);
    }

    @Override
    public PlayingCard removeCard() {
        return winner.removeCard();
    }

    @Override
    public String getName() {
        return "****** "+winner.getName() + " ******";
    }
}
