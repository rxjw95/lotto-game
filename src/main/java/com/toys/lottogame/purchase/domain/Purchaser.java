package com.toys.lottogame.purchase.domain;

import com.toys.lottogame.member.domain.MemberId;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Purchaser {

    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "purchaser_id"))
    private MemberId memberId;
    private String email;

    public Purchaser(String email) {
        this.email = email;
    }
}
