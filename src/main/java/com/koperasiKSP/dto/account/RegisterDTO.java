package com.koperasiKSP.dto.account;

import com.koperasiKSP.validation.UniqueEmail;
import com.koperasiKSP.validation.UniqueUsername;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Objects;

public class RegisterDTO{

    @NotBlank(message = "username tidak boleh kosong")
    @UniqueUsername(message = "Username sudah terdaftar")
    private final String username;

    @NotBlank(message = "password tidak boleh kosong")
    private final String password;

    @NotBlank(message = "nama tidak boleh kosong")
    private final String name;

    @NotBlank(message = "alamat tidak boleh kosong")
    private final String address;

    @NotBlank(message = "email tidak boleh kosong")
    @UniqueEmail(message = "email sudah terdaftar")
    @Email(message = "format email salah")
    private final String email;
    private final String role = "Member";

    public RegisterDTO(String username, String password, String name, String address, String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }
}
