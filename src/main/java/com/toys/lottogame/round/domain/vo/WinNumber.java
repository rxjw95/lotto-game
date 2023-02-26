package com.toys.lottogame.round.domain.vo;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Access(AccessType.FIELD)
public class WinNumber {
    private int win1;
    private int win2;
    private int win3;
    private int win4;
    private int win5;
    private int win6;
    private int bonus;

    public WinNumber(List<Integer> numbers) {
        if (numbers.size() != 7) {
            throw new IllegalArgumentException("win numbers size must be seven");
        }
        this.win1 = numbers.get(0);
        this.win2 = numbers.get(1);
        this.win3 = numbers.get(2);
        this.win4 = numbers.get(3);
        this.win5 = numbers.get(4);
        this.win6 = numbers.get(5);
        this.bonus = numbers.get(6);
    }

    public int getWin1() {
        return win1;
    }

    public int getWin2() {
        return win2;
    }

    public int getWin3() {
        return win3;
    }

    public int getWin4() {
        return win4;
    }

    public int getWin5() {
        return win5;
    }

    public int getWin6() {
        return win6;
    }

    public int getBonus() {
        return bonus;
    }
}
