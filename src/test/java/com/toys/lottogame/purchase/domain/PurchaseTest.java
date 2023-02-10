package com.toys.lottogame.purchase.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class PurchaseTest extends PurchaseDummies {

    @Test
    public void 진행중인_회차에서는_로또를_구매할_수_있다() {
        Purchase purchase = new Purchase(openedLotteryRoundDummy, lotteryDummy, purchaserDummy);
        assertThatNoException();
    }

    @Test
    public void 종료된_회차에서는_로또를_구매할_수_없다() {
        assertThatThrownBy(() -> new Purchase(closedLotteryRoundDummy, lotteryDummy, purchaserDummy), "round closed.");
        assertThatExceptionOfType(IllegalStateException.class);
    }

    @Test
    public void 구매자_정보가_있어야_한다() {
        assertThatThrownBy(() -> new Purchase(openedLotteryRoundDummy, lotteryDummy, null), "no purchase");
        assertThatNullPointerException();

    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    public void 구매가격은_로또의_게임의_수_곱하기_게임_가격이다(int size) {
        Purchase purchase = new Purchase(openedLotteryRoundDummy, getLotteryContainsGames(size), purchaserDummy);
        assertThat(purchase.getAmount()).isEqualTo(new Money(size * 1_000));
    }

}