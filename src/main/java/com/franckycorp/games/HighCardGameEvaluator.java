package com.franckycorp.games;

import com.franckycorp.model.IPlayer;
import com.franckycorp.model.PlayingCard;

import java.util.List;

public class HighCardGameEvaluator implements GameEvaluator {
    @Override
    public IPlayer evaluateWinner(List<IPlayer> players) {
        IPlayer bestPlayer = null;
        int bestRank = -1;
        int bestSuit = -1;

        for (IPlayer IPlayer : players) {
            boolean newBestPlayer = false;

            if (bestPlayer == null) {
                newBestPlayer = true;
            } else {
                PlayingCard pc = IPlayer.getCard(0);
                int thisRank = pc.getRank().value();
                if (thisRank >= bestRank) {
                    if (thisRank > bestRank) {
                        newBestPlayer = true;
                    } else {
                        if (pc.getSuit().value() > bestSuit) {
                            newBestPlayer = true;
                        }
                    }
                }
            }

            if (newBestPlayer) {
                bestPlayer = IPlayer;
                PlayingCard pc = IPlayer.getCard(0);
                bestRank = pc.getRank().value();
                bestSuit = pc.getSuit().value();
            }
        }
        return bestPlayer;
    }
}
