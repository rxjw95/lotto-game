package com.toys.lottogame.domain;

import jakarta.persistence.*;

@Entity
public class LottoGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String lottoGroupId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    protected LottoGroup() {
    }

    public LottoGroup(User user) {
        this.user = user;
    }

}
