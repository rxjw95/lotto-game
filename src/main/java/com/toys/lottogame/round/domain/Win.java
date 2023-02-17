package com.toys.lottogame.round.domain;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Win {
    @EmbeddedId
    private WinId winId;
    private int win1;
    private int win2;
    private int win3;
    private int win4;
    private int win5;
    private int win6;
    private int bonus;

    public Win(List<Integer> winNumbers) {
        this.win1 = winNumbers.get(0);
        this.win2 = winNumbers.get(1);
        this.win3 = winNumbers.get(2);
        this.win4 = winNumbers.get(3);
        this.win5 = winNumbers.get(4);
        this.win6 = winNumbers.get(5);
        this.bonus = winNumbers.get(6);
    }


}
