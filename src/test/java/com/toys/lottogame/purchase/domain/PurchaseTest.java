package com.toys.lottogame.purchase.domain;

import com.toys.lottogame.purchase.domain.vo.Games;
import com.toys.lottogame.purchase.domain.vo.Money;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseTest extends PurchaseDomainDummy {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    public void 구매가격은_로또의_게임의_수_곱하기_게임_가격이다(int count) {
        Games gameDummies = makeGamesDummy(count);
        Purchaser purchaserDummy = new Purchaser("wafo");

        Purchase purchase = new Purchase(gameDummies, purchaserDummy);
        Assertions.assertThat(purchase.getAmount()).isEqualTo(new Money(count * 1_000));
    }

}