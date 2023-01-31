package com.toys.lottogame.vo;

import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode
public class LottoNumbersCollection {
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbersCollection(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

}
