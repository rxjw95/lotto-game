package com.toys.lottogame.purchase.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class LotteryTest extends PurchaseDomainTest {

    @Test
    public void 게임의_개수는_1개_보다_같거나_크고_5개_보다_작거나_같다() {
        Lottery lottery = new Lottery(getGameDummies(3));
        assertThatNoException();
    }

    @Test
    public void 게임이_없으면_NullPointException() {
        assertThatThrownBy(() -> new Lottery(null), "games is null.");
        assertThatNullPointerException();
    }

    @Test
    public void 게임이_다섯개_이상이면_IllegalArgumentException() {
        assertThatThrownBy(() -> new Lottery(getGameDummies(6)), "games size must be 1 <= game <= 5 in lottery.");
        assertThatIllegalArgumentException();
    }

    private List<Game> getGameDummies(int gameSize) {
        return Stream.generate(() -> new Game(List.of(1, 2, 3, 4, 5, 6)))
                .limit(gameSize)
                .toList();
    }

}