package com.toys.lottogame.round.service;

import com.toys.lottogame.common.util.LotteryNumberGenerator;
import com.toys.lottogame.round.domain.*;
import com.toys.lottogame.round.domain.vo.WinNumber;
import jakarta.transaction.Transactional;
import org.springframework.scheduling.annotation.Scheduled;

public class AnnounceService {
    private final LotteryRoundRepository lotteryRoundRepository;
    private final WinRepository winRepository;
    private final EventPublisher eventPublisher;

    public AnnounceService(LotteryRoundRepository lotteryRoundRepository, WinRepository winRepository, EventPublisher eventPublisher) {
        this.lotteryRoundRepository = lotteryRoundRepository;
        this.winRepository = winRepository;
        this.eventPublisher = eventPublisher;
    }

    @Scheduled(cron = "0 0 20 ? * SAT")
    @Transactional
    public void announceWinNumber() {
        WinNumber winNumber = new WinNumber(LotteryNumberGenerator.autoGenerateWinNumber());
        Win win = new Win(winNumber);

        winRepository.save(win);

        LotteryRound round = lotteryRoundRepository.findClosedRoundRecently();
        round.announce(win);

        eventPublisher.publish(winNumber);
    }
}
