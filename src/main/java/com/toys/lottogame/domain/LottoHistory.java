package com.toys.lottogame.domain;

import jakarta.persistence.*;

@Entity
public class LottoHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "round_id")
    private LottoRound round;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private LottoGroup lottoGroupId;

}
