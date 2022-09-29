package com.koperasiKSP.service;

import com.koperasiKSP.dto.account.RegisterDTO;
import com.koperasiKSP.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAll();
    void save(Account account);
    void delete(Account account);
    void deleteByUsername(String username);
    Account findByUsername(String username);

    void register(RegisterDTO dto);

    boolean isExistByUsername(String username);

    boolean isExistByEmail(String email);
}
