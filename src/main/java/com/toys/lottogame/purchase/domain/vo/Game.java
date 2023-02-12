package com.toys.lottogame.purchase.domain.vo;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Game {
    private int pick1;
    private int pick2;
    private int pick3;
    private int pick4;
    private int pick5;
    private int pick6;

    public Game(List<Integer> picks) {
        verify(picks);
        this.pick1 = picks.get(0);
        this.pick2 = picks.get(1);
        this.pick3 = picks.get(2);
        this.pick4 = picks.get(3);
        this.pick5 = picks.get(4);
        this.pick6 = picks.get(5);
    }

    private void verify(List<Integer> picks) {
        Objects.requireNonNull(picks, "picks is null.");
        verifySizeSixWithoutDuplication(picks);
        verifyGreaterThanOrEqualOneAndLessThanOrEqualFortyFive(picks);
    }

    private void verifySizeSixWithoutDuplication(List<Integer> picks) {
        if (picks.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("picks must not be duplicated and picks size must be six.");
        }
    }

    private void verifyGreaterThanOrEqualOneAndLessThanOrEqualFortyFive(List<Integer> picks) {
        if (picks.stream().anyMatch(pick -> 1 > pick || 45 < pick)) {
            throw new IllegalArgumentException("pick number range must be 1 <= number <= 45");
        }
    }
}
