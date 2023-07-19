package com.example.accountsapplication.services;

import com.example.accountsapplication.models.Account;
import com.example.accountsapplication.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void withdrawMoney(BigDecimal money, Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Account does not exist"));

        if (account.getBalance().compareTo(money) < 0) {
            throw new IllegalArgumentException("Not enough money");
        }

        account.setBalance(account.getBalance().subtract(money));
        accountRepository.save(account);
    }

    @Override
    public void transferMoney(BigDecimal money, Long id) {
        Account accountToTransferTo = accountRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Account does not exist"));

        if (money.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Cannot deposit negative money");
        }

        accountToTransferTo.setBalance(accountToTransferTo.getBalance().add(money));
        accountRepository.save(accountToTransferTo);
    }
}
