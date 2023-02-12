package com.toys.lottogame.purchase.domain.vo;


import com.toys.lottogame.purchase.domain.PurchaseDomainDummy;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GamesTest extends PurchaseDomainDummy {

    @Test
    public void 게임은_최소_하나가_있어야_한다() {
        assertThatNoException()
                .isThrownBy(() -> new Games(List.of(new Game(List.of(1, 2, 3, 4, 5, 6)))));
    }

    @Test
    public void 게임이_없다면_IllegalArgumentException() {
        assertThatThrownBy(() -> new Games(List.of()), "games must be not null or empty.")
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 게임이_다섯개를_초과하면_IllegalArgumentException() {
        assertThatThrownBy(() -> {
            new Games(List.of(makeGameDummy(), makeGameDummy(), makeGameDummy(), makeGameDummy(), makeGameDummy(), makeGameDummy()));
        }, "games max count must be five.")
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

}