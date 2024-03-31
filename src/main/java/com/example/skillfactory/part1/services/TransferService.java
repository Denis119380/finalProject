package com.example.skillfactory.part1.services;

import com.example.skillfactory.part1.dto.Account;
import com.example.skillfactory.part1.repositories.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class TransferService {
    private final AccountRepository accountRepository;
    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public BigDecimal getBalance(long idUser) {
        Account user = accountRepository.findAccountById(idUser);
        return user.getBalance();
    }

    public boolean takeMoney(long idUser, BigDecimal money) {
        Account user = accountRepository.findAccountById(idUser);
        if(user.getBalance().compareTo(money) < 0) return false;
        BigDecimal userNewBalance = user.getBalance().subtract(money);
        accountRepository.changeBalance(idUser, userNewBalance);
        return true;
    }

    public void putMoney(long idUser, BigDecimal money) {
        Account user = accountRepository.findAccountById(idUser);
        BigDecimal userNewBalance = user.getBalance().add(money);
        accountRepository.changeBalance(idUser, userNewBalance);
    }
}
