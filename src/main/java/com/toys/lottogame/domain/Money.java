package com.toys.lottogame.domain;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class Money {

    private Long money;

    protected Money() {
    }

    public Money(Long money) {
        Objects.requireNonNull(money, "금액이 0보다 작을 수 없습니다.");
        this.money = money;
    }

    public Money add(Money money) {
        return new Money(this.money + money.money);
    }

    public Money subtract(Money money) {
        return new Money(this.money - money.money);
    }

}
