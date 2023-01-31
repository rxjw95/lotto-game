package com.toys.lottogame.vo;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class LottoNumber {
    private final int pick1;
    private final int pick2;
    private final int pick3;
    private final int pick4;
    private final int pick5;
    private final int pick6;

    public LottoNumber(int pick1, int pick2, int pick3, int pick4, int pick5, int pick6) {
        this.pick1 = pick1;
        this.pick2 = pick2;
        this.pick3 = pick3;
        this.pick4 = pick4;
        this.pick5 = pick5;
        this.pick6 = pick6;
    }
}
