package com.toys.lottogame.purchase.domain;

import java.util.List;
import java.util.Objects;

public class Lottery {
    private final List<Game> games;

    public Lottery(List<Game> games) {
        Objects.requireNonNull(games, "games is null.");
        verifyGamesMoreThanOrEqualToOneAndLessThanOrEqualToFive(games);
        this.games = games;
    }

    private void verifyGamesMoreThanOrEqualToOneAndLessThanOrEqualToFive(List<Game> games) {
        if (1 > games.size() || 5 < games.size()) {
            throw new IllegalArgumentException("games size must be 1 <= game <= 5 in lottery.");
        }
    }

    public int getGameCount() {
        return games.size();
    }
}
