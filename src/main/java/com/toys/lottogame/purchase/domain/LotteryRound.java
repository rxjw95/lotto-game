package com.toys.lottogame.purchase.domain;

public class LotteryRound {
    private PurchaseAvailability availability;
    private int round;

    public LotteryRound(int round) {
        this.availability = PurchaseAvailability.AVAILABLE;
        this.round = round;
    }

    public void validatePurchaseAvailable() {
        if (availability == PurchaseAvailability.UNAVAILABLE) {
            throw new IllegalStateException("round closed");
        }
    }

    public void close() {
        if (availability == PurchaseAvailability.AVAILABLE) {
            availability = PurchaseAvailability.UNAVAILABLE;
        }
    }

    private enum PurchaseAvailability {
        AVAILABLE, UNAVAILABLE
    }
}
