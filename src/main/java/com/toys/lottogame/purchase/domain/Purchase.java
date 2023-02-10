package com.toys.lottogame.purchase.domain;

import java.util.Objects;
import java.util.UUID;

public class Purchase {
    private static final int GAME_PRICE = 1_000;

    private String purchaseId;
    private LotteryRound lotteryRound;
    private Purchaser purchaser;
    private Lottery lottery;
    private Money amounts;

    public Purchase(LotteryRound lotteryRound, Lottery lottery, Purchaser purchaser) {
        this.purchaseId = UUID.randomUUID().toString();
        setLotteryRound(lotteryRound);
        setPurchaser(purchaser);
        setLottery(lottery);
        calculateAmounts();
    }

    private void setLotteryRound(LotteryRound lotteryRound) {
        Objects.requireNonNull(lotteryRound, "no lottery round");
        lotteryRound.validatePurchaseAvailable();
        this.lotteryRound = lotteryRound;
    }

    private void setPurchaser(Purchaser purchaser) {
        Objects.requireNonNull(purchaser, "no purchase");
        this.purchaser = purchaser;
    }

    private void setLottery(Lottery lottery) {
        Objects.requireNonNull(lottery, "no lottery");
        this.lottery = lottery;
    }

    private void calculateAmounts() {
        this.amounts = new Money(lottery.getGameCount() * GAME_PRICE);
    }

}
