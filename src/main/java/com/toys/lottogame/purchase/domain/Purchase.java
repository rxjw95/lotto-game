package com.toys.lottogame.purchase.domain;

import com.toys.lottogame.common.CreatedEntity;
import com.toys.lottogame.common.vo.Money;
import com.toys.lottogame.purchase.domain.vo.Game;
import com.toys.lottogame.purchase.domain.vo.Games;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Access(AccessType.FIELD)
public class Purchase extends CreatedEntity {
    private static final int GAME_PRICE = 1_000;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String purchaseId;

    private Long roundId;

    @Embedded
    private Purchaser purchaser;

    @ElementCollection
    @CollectionTable(name = "game", joinColumns = @JoinColumn(name = "purchase_id"))
    private List<Game> games;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "amounts"))
    private Money amounts;

    public Purchase(Games games, Purchaser purchaser) {
        setPurchaser(purchaser);
        setGames(games);
        calculateAmounts();
    }

    private void setPurchaser(Purchaser purchaser) {
        Objects.requireNonNull(purchaser, "no purchase");
        this.purchaser = purchaser;
    }

    private void setGames(Games games) {
        Objects.requireNonNull(games, "no games");
        this.games = games.toList();
    }

    private void calculateAmounts() {
        this.amounts = new Money(games.size() * GAME_PRICE);
    }

    public Money getAmount() {
        return amounts;
    }

}
