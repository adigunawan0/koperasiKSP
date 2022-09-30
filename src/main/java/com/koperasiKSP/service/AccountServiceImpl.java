package com.koperasiKSP.service;

import com.koperasiKSP.dto.account.RegisterDTO;
import com.koperasiKSP.entity.Account;
import com.koperasiKSP.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }

    @Override
    public void delete(Account account) {
        accountRepository.delete(account);
    }

    @Override
    public void deleteByUsername(String username) {
        Account entity = findByUsername(username);
        delete(entity);
    }

    @Override
    public Account findByUsername(String username) {
        Optional<Account> optionalAccount = accountRepository.findById(username);
        return optionalAccount.orElse(null);
    }

    @Override
    public void register(RegisterDTO dto) {
        // register account tanpa hashing BCrypt dengan role Member
        save(new Account(
                dto.getUsername(),
                dto.getPassword(),
                "Member",
                dto.getName(),
                dto.getAddress(),
                dto.getEmail()
        ));
    }

    @Override
    public boolean isExistByUsername(String username) {
        Optional<Account> optionalAccount = accountRepository.findById(username);
        return optionalAccount.isPresent();
    }

    @Override
    public boolean isExistByEmail(String email) {
        Long countByEmail = accountRepository.countByEmail(email);
        return countByEmail > 0;
    }
}
