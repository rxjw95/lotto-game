package com.toys.lottogame.vo;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class WinNumber {
    private final Integer num1;
    private final Integer num2;
    private final Integer num3;
    private final Integer num4;
    private final Integer num5;
    private final Integer num6;

    public WinNumber(Integer num1, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6) {
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
        this.num4 = num4;
        this.num5 = num5;
        this.num6 = num6;
    }
}
