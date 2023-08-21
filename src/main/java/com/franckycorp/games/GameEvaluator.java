package com.franckycorp.games;

import com.franckycorp.model.Player;

import java.util.List;

public interface GameEvaluator {

    Player evaluateWinner(List<Player> players);
}
