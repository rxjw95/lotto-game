package com.toys.lottogame.common.vo;

public class Money {

    static public final Money ZERO = new Money(0);

    private int value;


    public Money(int value) {
        this.value = value;
    }

    protected Money() {
    }

    public int getValue() {
        return value;
    }
}
