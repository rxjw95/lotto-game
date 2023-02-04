package com.toys.lottogame.vo;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Money {

    private final long money;

    public Money(long money) {
        this.money = money;
    }

    public Money add(Money money) {
        return new Money(this.money + money.money);
    }

    public Money subtract(Money money) {
        return new Money(this.money - money.money);
    }

}
