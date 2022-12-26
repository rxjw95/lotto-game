package com.toys.lottogame.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class LottoRound {

    @Id
    private Long roundId;

    protected LottoRound() {
    }

    public LottoRound(Long roundId) {
        this.roundId = roundId;
    }

}
