package com.koperasiKSP.rest;

import com.koperasiKSP.dto.account.RegisterDTO;
import com.koperasiKSP.dto.account.RequestTokenDTO;
import com.koperasiKSP.dto.account.ResponseTokenDTO;
import com.koperasiKSP.entity.Account;
import com.koperasiKSP.service.AccountService;
import com.koperasiKSP.utility.JwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtToken jwtToken;

    // Grant Access: Member
    @PostMapping("register")
    public ResponseEntity<String> register(@Valid @RequestBody RegisterDTO dto){
        // pakai error handling
        accountService.register(dto);
        return new ResponseEntity<>(dto.getUsername() + " berhasil terdaftar sebagai " + dto.getRole(), HttpStatus.CREATED);
    }

    // perlu authentication untuk security
    @PostMapping("authenticate")
    public ResponseTokenDTO authenticate(@RequestBody RequestTokenDTO dto){
        try {
            UsernamePasswordAuthenticationToken token =
                    new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword());
            Authentication authentication = authenticationManager.authenticate(token);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Can not authenticate", e);
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(dto.getUsername());

        String role = accountService.getAccountRole(dto.getUsername());
        String token = jwtToken.generateToken(
                dto.getSubject(),
                dto.getUsername(),
                dto.getSecretKey(),
                role,
                dto.getAudience()
        );

        ResponseTokenDTO responseTokenDTO = new ResponseTokenDTO(dto.getUsername(), role, token);
        return responseTokenDTO;
    }

    // perlu Paging Account Role = Member
    @GetMapping
    public ResponseEntity<Page<Account>> index(@RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "") String username,
                                               @RequestParam(defaultValue = "") String nama){
        Page<Account> accountPage = accountService.getDTOPages(username, nama, page);
        return new ResponseEntity<>(accountPage, HttpStatus.OK);
    }
}
