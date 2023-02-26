package com.toys.lottogame.round.domain;

import com.toys.lottogame.round.domain.vo.WinNumber;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Win {
    @Id
    @GeneratedValue
    private Long winId;

    @Embedded
    private WinNumber winNumber;

    public Win(WinNumber winNumbers) {
        this.winNumber = winNumbers;
    }

}
