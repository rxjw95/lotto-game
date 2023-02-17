package com.toys.lottogame.round.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
@Embeddable
public class WinId implements Serializable {
    @Column(name = "win_id")
    private Long id;
}
