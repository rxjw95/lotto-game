package com.toys.lottogame.round.domain;

import jakarta.persistence.Column;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class LotteryRoundId implements Serializable {
    @Column(name = "lottery_round_id")
    private Long id;
}
