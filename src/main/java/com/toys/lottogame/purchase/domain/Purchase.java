package com.toys.lottogame.purchase.domain;

import com.toys.lottogame.purchase.domain.vo.Game;
import com.toys.lottogame.purchase.domain.vo.Games;
import com.toys.lottogame.purchase.domain.vo.Money;
import com.toys.lottogame.round.domain.LotteryRoundId;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Access(AccessType.FIELD)
public class Purchase {
    private static final int GAME_PRICE = 1_000;

    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.UUID)
    private PurchaseId purchaseId;

    @Embedded
    private LotteryRoundId lotteryRoundId;

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

    protected Purchase() {
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
