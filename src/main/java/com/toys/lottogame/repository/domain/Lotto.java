package com.toys.lottogame.repository.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Lotto {

    @Id
    @GeneratedValue
    private Long lottoId;

    @OneToMany(mappedBy = "lotto")
    private List<Game> games = new ArrayList<>();

    protected Lotto() {
    }

    public void add(Game game) {
        games.add(game);
    }

}
