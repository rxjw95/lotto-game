package com.toys.lottogame.domain;

import com.toys.lottogame.vo.Money;
import jakarta.persistence.*;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(name = "nickname_unique", columnNames = {"nickname"}))
public class User {

    @Id
    @GeneratedValue
    private Long userId;

    private String nickname;
    private String email;

    @Embedded
    private Money money;

    protected User() {
    }

    public User(String nickname, String email, Money money) {
        this.nickname = nickname;
        this.email = email;
        this.money = money;
    }

}
