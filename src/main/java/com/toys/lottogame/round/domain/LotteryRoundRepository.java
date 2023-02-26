package com.toys.lottogame.round.domain;

import com.toys.lottogame.round.domain.vo.RoundStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LotteryRoundRepository extends JpaRepository<LotteryRound, Long> {
    Optional<LotteryRound> findByRoundStatus(RoundStatus status);

    @Query("select r from LotteryRound r where r.lotteryRoundId = (select max(rr.lotteryRoundId) from LotteryRound rr)")
    LotteryRound findClosedRoundRecently();
}
