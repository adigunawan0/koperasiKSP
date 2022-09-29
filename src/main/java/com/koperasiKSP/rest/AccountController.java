package com.koperasiKSP.rest;

import com.koperasiKSP.dto.account.RegisterDTO;
import com.koperasiKSP.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class AccountController {

    @Autowired
    private AccountService accountService;

    // Grant Access: Member
    @PostMapping("register")
    public ResponseEntity<String> register(@Valid @RequestBody RegisterDTO dto){
        // pakai error handling
        accountService.register(dto);
        return new ResponseEntity<>(dto.getUsername() + " berhasil terdaftar sebagai " + dto.getRole(), HttpStatus.CREATED);
    }

    // perlu authentication untuk security
    // perlu Paging Account Role = Member
    // perlu delete account
    // perlu update Account
}
