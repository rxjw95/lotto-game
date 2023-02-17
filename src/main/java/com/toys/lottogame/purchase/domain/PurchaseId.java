package com.toys.lottogame.purchase.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class PurchaseId implements Serializable {
    @Column(name = "purchase_id")
    private String id;
}
