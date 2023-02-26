package com.toys.lottogame.round.domain;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Winner {
    private String memberId;
    private String email;

    public Winner(String memberId, String email) {
        this.memberId = memberId;
        this.email = email;
    }

}
