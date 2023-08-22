package com.franckycorp.games;

import com.franckycorp.model.IPlayer;

import java.util.List;

public interface GameEvaluator {

    IPlayer evaluateWinner(List<IPlayer> players);
}
