package com.toys.lottogame.purchase.domain;

import com.toys.lottogame.purchase.domain.vo.Game;
import com.toys.lottogame.purchase.domain.vo.Games;

import java.util.List;
import java.util.stream.Stream;

public class PurchaseDomainDummy {
    private final Game game = new Game(List.of(1, 2, 3, 4, 5, 6));
    private final Purchaser purchaser = new Purchaser("tester@email.com");

    protected Game makeGameDummy() {
        return game;
    }

    protected Games makeGamesDummy(int count) {
        return new Games(
                Stream.generate(this::makeGameDummy)
                        .limit(count)
                        .toList()
        );
    }

    protected Purchaser makePurchaserDummy() {
        return purchaser;
    }

}
