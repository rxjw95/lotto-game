package com.toys.lottogame.repository.domain;

import com.toys.lottogame.vo.RoundStatus;
import com.toys.lottogame.vo.WinNumber;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class LottoRound {

    @Id
    private Long roundId;

    @Embedded
    private WinNumber winNumber;
    private Integer bonusNumber;
    private RoundStatus status;

    protected LottoRound() {
    }

    private LottoRound(Long roundId, RoundStatus status) {
        this.roundId = roundId;
        this.status = status;
    }

    public static LottoRound start(Long round, RoundStatus status) {
        return new LottoRound(round, status);
    }

    public void announce(WinNumber winNumber, Integer bonusNumber) {
        this.winNumber = winNumber;
        this.bonusNumber = bonusNumber;
    }

}
