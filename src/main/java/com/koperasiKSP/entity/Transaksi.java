package com.koperasiKSP.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Transaksi")
public class Transaksi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PengajuanId")
    private Pengajuan pengajuanId;

    @Column(name = "Nominal", nullable = false, precision = 19, scale = 2)
    private BigDecimal nominal;

    @Column(name = "Keterangan")
    private String keterangan;

    @Column(name = "Tanggal", nullable = false)
    private LocalDate tanggal;

    public LocalDate getTanggal() {
        return tanggal;
    }

    public void setTanggal(LocalDate tanggal) {
        this.tanggal = tanggal;
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

    public Pengajuan getPengajuanId() {
        return pengajuanId;
    }

    public void setPengajuanId(Pengajuan pengajuanId) {
        this.pengajuanId = pengajuanId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}