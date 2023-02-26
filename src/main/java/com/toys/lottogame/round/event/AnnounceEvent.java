package com.toys.lottogame.round.event;


import com.toys.lottogame.round.domain.vo.WinNumber;

public class AnnounceEvent {
    private WinNumber winNumber;

    public AnnounceEvent(Object source, WinNumber winNumber) {
        this.winNumber = winNumber;
    }

    public WinNumber getWinNumber() {
        return winNumber;
    }
}
