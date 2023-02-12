package com.toys.lottogame.purchase.domain.vo;

import com.toys.lottogame.purchase.domain.PurchaseDomainDummy;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameTest extends PurchaseDomainDummy {

    @Test
    public void 게임은_최소1부터_최대45까지의_6개_번호로_구성된다() {
        assertThatNoException()
                .isThrownBy(this::makeGameDummy);
    }

    @Test
    public void 게임에_유효하지_않는_번호가_포함된_경우_IllegalArgumentException() {
        assertThatThrownBy(() -> new Game(List.of(1, 46, 4, 5, 3, 1)), "pick number range must be 1 <= number <= 45")
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 게임이_6개_번호로_구성되지_않은_경우_IllegalArgumentException() {
        assertThatThrownBy(() -> new Game(List.of(1, 2, 3)), "picks must not be duplicated and picks size must be six.")
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

}