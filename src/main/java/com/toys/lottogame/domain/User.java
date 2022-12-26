package com.toys.lottogame.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    private String userId;

    private String password;
    private String nickname;
    private String email;
    private Money money;

    protected User() {
    }

    public User(String password, String nickname, String email, Money money) {
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.money = money;
    }

}
