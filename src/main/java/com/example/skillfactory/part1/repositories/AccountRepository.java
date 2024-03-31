package com.example.skillfactory.part1.repositories;

import com.example.skillfactory.part1.dto.Account;
import com.example.skillfactory.part1.repositories.mappers.AccountRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class AccountRepository {
    private final JdbcTemplate jdbc;
    public AccountRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Account findAccountById(long id) {
        String sql = "SELECT * FROM bank WHERE id = ?";
        return jdbc.queryForObject(sql, new AccountRowMapper(), id);
    }

    public void changeBalance(long id, BigDecimal balance) {
        String sql = "UPDATE bank SET balance = ? WHERE id = ?";
        jdbc.update(sql, balance, id);
    }
}
