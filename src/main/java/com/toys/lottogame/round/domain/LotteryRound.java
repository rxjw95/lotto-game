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

    @EmbeddedId
    @GeneratedValue
    private LotteryRoundId lotteryRoundId;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "total_amount"))
    private Money totalAmount;

    @OneToOne
    @JoinColumn(name = "win_id")
    private Win win;

    @ElementCollection
    @CollectionTable(name = "winners", joinColumns = @JoinColumn(name = "lottery_round_id"))
    private List<Winner> winner = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private RoundStatus roundStatus = RoundStatus.OPEN;

    public void close() {
        roundStatus = RoundStatus.CLOSE;
    }
}
