package com.toys.lottogame.purchase.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseTest {

    @Test
    public void 구매자_정보가_있어야_한다() {

    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    public void 구매가격은_로또의_게임의_수_곱하기_게임_가격이다(int size) {
    }

}