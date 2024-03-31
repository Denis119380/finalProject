package com.example.skillfactory.part1.dto;

import java.math.BigDecimal;

public class Account {
    private long id;
    private BigDecimal balance;

    public static Account of(long id, BigDecimal balance) {
        Account account = new Account();
        account.setId(id);
        account.setBalance(balance);
        return account;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
