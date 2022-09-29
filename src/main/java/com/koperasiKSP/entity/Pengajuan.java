package com.koperasiKSP.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Pengajuan")
public class Pengajuan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "Username")
    private Account account;

    @Column(name = "Nominal", nullable = false, precision = 19, scale = 2)
    private BigDecimal nominal;

    @Column(name = "Keterangan")
    private String keterangan;

    @Column(name = "Start_Date")
    private LocalDate startDate;

    @Column(name = "End_Date")
    private LocalDate endDate;

    public Pengajuan() {
    }
    public Pengajuan(Long id, Account account, BigDecimal nominal, String keterangan, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.account = account;
        this.nominal = nominal;
        this.keterangan = keterangan;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Pengajuan(Account account, BigDecimal nominal, String keterangan, LocalDate startDate, LocalDate endDate) {
        this.account = account;
        this.nominal = nominal;
        this.keterangan = keterangan;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public BigDecimal getNominal() {
        return nominal;
    }

    public void setNominal(BigDecimal nominal) {
        this.nominal = nominal;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}