package com.toys.lottogame.repository.domain;

import com.toys.lottogame.vo.LottoNumber;
import jakarta.persistence.*;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String gameId;

    @Embedded
    private LottoNumber lottoNumber;
    private Integer place;

    @ManyToOne
    @JoinColumn(name = "lotto_id")
    private Lotto lotto;

    protected Game() {
    }

    public void registerFor(Lotto lotto) {
        lotto.add(this);
        this.lotto = lotto;
    }
}
