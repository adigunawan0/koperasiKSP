package com.koperasiKSP.service;

import com.koperasiKSP.ApplicationUserDetails;
import com.koperasiKSP.dto.account.RegisterDTO;
import com.koperasiKSP.entity.Account;
import com.koperasiKSP.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService, UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

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
        String hashPassword = passwordEncoder.encode(dto.getPassword());
        save(new Account(
                dto.getUsername(),
                hashPassword,
                dto.getRole(),
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

    @Override
    public String getAccountRole(String username) {
        return findByUsername(username).getRole();
    }

    @Override
    public Page<Account> getDTOPages(String username, String nama, int page) {
        Pageable pageable = PageRequest.of(page-1, 3, Sort.by("username"));
        return accountRepository.getDTOPages(username, nama, pageable);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new ApplicationUserDetails(findByUsername(username));
    }
}
