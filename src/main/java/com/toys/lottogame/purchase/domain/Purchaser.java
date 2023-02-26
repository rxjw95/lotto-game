package com.toys.lottogame.purchase.domain;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Purchaser {
    private String memberId;
    private String email;

    public Purchaser(String memberId, String email) {
        this.memberId = memberId;
        this.email = email;
    }
}
