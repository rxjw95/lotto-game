package com.toys.lottogame.purchase.domain;

import java.util.List;
import java.util.stream.Stream;

public class PurchaseDummies {
    protected LotteryRound openedLotteryRoundDummy;
    protected LotteryRound closedLotteryRoundDummy;
    protected Game gameDummy;
    protected Lottery lotteryDummy;
    protected Purchaser purchaserDummy;

    public PurchaseDummies() {
        openedLotteryRoundDummy = new LotteryRound(2);
        closedLotteryRoundDummy = new LotteryRound(1);
        closedLotteryRoundDummy.close();
        gameDummy = new Game(List.of(1, 2, 3, 4, 5, 6));
        lotteryDummy = new Lottery(List.of(gameDummy));
        purchaserDummy = new Purchaser("wafo");
    }

    protected Lottery getLotteryContainsGames(int size) {
        return new Lottery(
                Stream
                        .generate(() -> new Game(List.of(1, 2, 3, 4, 5, 6)))
                        .limit(size)
                        .toList()
        );
    }
}
