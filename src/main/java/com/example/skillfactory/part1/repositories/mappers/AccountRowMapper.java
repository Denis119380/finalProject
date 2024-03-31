package com.example.skillfactory.part1.repositories.mappers;

import com.example.skillfactory.part1.dto.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<Account> {
    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account a = new Account();
        a.setId(resultSet.getInt("id"));
        a.setBalance(resultSet.getBigDecimal("balance"));
        return a;
    }
}
