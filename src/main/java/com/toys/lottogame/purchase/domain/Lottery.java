package com.toys.lottogame.purchase.domain;

import java.util.List;

public class Lottery {
    private final List<Game> games;

    public Lottery(List<Game> games) {
        this.games = games;
    }

    public int getGameCount() {
        return games.size();
    }
}
