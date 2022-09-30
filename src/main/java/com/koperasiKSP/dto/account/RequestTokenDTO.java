package com.koperasiKSP.dto.account;

public class RequestTokenDTO {

    private String username;
    private String password;
    private String subject;
    private String secretKey;
    private String audience;

    public RequestTokenDTO(){
        this.secretKey = "liberate-tutuma-ex-inferis-ad-astra-per-aspera";
        this.audience = "KoperasiKSP";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }
}
