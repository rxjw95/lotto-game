package com.toys.lottogame.round.domain;


import com.toys.lottogame.common.vo.Money;
import com.toys.lottogame.round.domain.vo.RoundStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Access(AccessType.FIELD)
public class LotteryRound {

    @Id
    @GeneratedValue
    private Long lotteryRoundId;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "total_amount"))
    private Money totalAmount;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "win_id")
    private Win win;

    @ElementCollection
    @CollectionTable(name = "winners", joinColumns = @JoinColumn(name = "lottery_round_id"))
    private List<Winner> winner = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private RoundStatus roundStatus;

    public LotteryRound(Money initialMoney) {
        this.totalAmount = initialMoney;
    }

    public void open() {
        roundStatus = RoundStatus.OPEN;
    }

    public void close() {
        if (roundStatus == RoundStatus.CLOSE) {
            throw new RuntimeException("Already closed.");
        }
        roundStatus = RoundStatus.CLOSE;
    }

    public void announce(Win win) {
        this.win = win;
    }

    public RoundStatus getRoundStatus() {
        return roundStatus;
    }
}
