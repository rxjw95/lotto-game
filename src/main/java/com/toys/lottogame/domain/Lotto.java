package com.toys.lottogame.domain;

import jakarta.persistence.*;

@Entity
public class Lotto {

    @Id
    @GeneratedValue
    private Long LottoId;

    @ManyToOne
    @JoinColumn(name = "lotto_group_id")
    private LottoGroup lottoGroup;

    private String pickNum1;
    private String pickNum2;
    private String pickNum3;
    private String pickNum4;
    private String pickNum5;
    private String pickNum6;

    protected Lotto() {
    }

    public Lotto(
            LottoGroup lottoGroup,
            String pickNum1,
            String pickNum2,
            String pickNum3,
            String pickNum4,
            String pickNum5,
            String pickNum6) {
        this.lottoGroup = lottoGroup;
        this.pickNum1 = pickNum1;
        this.pickNum2 = pickNum2;
        this.pickNum3 = pickNum3;
        this.pickNum4 = pickNum4;
        this.pickNum5 = pickNum5;
        this.pickNum6 = pickNum6;
    }

}
