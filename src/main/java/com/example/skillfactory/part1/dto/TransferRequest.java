package com.example.skillfactory.part1.dto;

import java.math.BigDecimal;

public class TransferRequest {
    private long id;
    private BigDecimal money;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
