package com.toys.lottogame.purchase.domain.vo;

import java.util.List;

public class Games {
    private final List<Game> games;

    public Games(List<Game> games) {
        verifyNullAndEmpty(games);
        verifyMoreThanFive(games);
        this.games = games;
    }

    private void verifyNullAndEmpty(List<Game> games) {
        if (games == null || games.isEmpty()) {
            throw new IllegalArgumentException("games must be not null or empty.");
        }
    }

    private void verifyMoreThanFive(List<Game> games) {
        if (games.size() > 5) {
            throw new IllegalArgumentException("games max count must be five");
        }
    }

    public List<Game> toList() {
        return games;
    }

    public int getCount() {
        return games.size();
    }
}
