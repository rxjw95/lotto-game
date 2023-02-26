package com.toys.lottogame.common.util;

import java.security.SecureRandom;
import java.util.List;

public class LotteryNumberGenerator {

    private static final SecureRandom secureRandom = new SecureRandom();

    private static final int WIN_NUMBER_COUNT = 6;
    private static final int NUMBER_MIN_BOUND = 1;
    private static final int NUMBER_MAX_BOUND = 46;

    public static List<Integer> autoGenerateWinNumber() {
        return secureRandom.ints(WIN_NUMBER_COUNT, NUMBER_MIN_BOUND, NUMBER_MAX_BOUND).boxed().toList();
    }
}
