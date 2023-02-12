package com.toys.lottogame.purchase.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class PurchaseId implements Serializable {
    @Column(name = "purchase_id")
    private String id;
}
