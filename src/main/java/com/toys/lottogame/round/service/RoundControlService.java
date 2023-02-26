package com.toys.lottogame.round.service;

import com.toys.lottogame.common.vo.Money;
import com.toys.lottogame.round.domain.LotteryRound;
import com.toys.lottogame.round.domain.LotteryRoundRepository;
import com.toys.lottogame.round.domain.vo.RoundStatus;
import jakarta.transaction.Transactional;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class RoundControlService {

    private final LotteryRoundRepository lotteryRoundRepository;

    public RoundControlService(LotteryRoundRepository lotteryRoundRepository) {
        this.lotteryRoundRepository = lotteryRoundRepository;
    }

    @Scheduled(cron = "0 0 0 ? * MON")
    @Transactional
    public void open() {
        LotteryRound lotteryRound = new LotteryRound(Money.ZERO);
        lotteryRound.open();
        lotteryRoundRepository.save(lotteryRound);
    }

    @Scheduled(cron = "0 0 18 ? * SAT")
    @Transactional
    public void close() {
        LotteryRound round = lotteryRoundRepository.findByRoundStatus(RoundStatus.OPEN)
                .orElseThrow(() -> new IllegalArgumentException("Cannot find round"));
        round.close();
    }

}
