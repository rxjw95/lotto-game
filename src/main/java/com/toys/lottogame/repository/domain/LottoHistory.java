package com.toys.lottogame.repository.domain;

import jakarta.persistence.*;

@Entity
public class LottoHistory extends CreateAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "round_id")
    private LottoRound round;

    @ManyToOne
    @JoinColumn(name = "lotto_id")
    private Lotto lotto;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
