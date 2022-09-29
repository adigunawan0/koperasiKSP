package com.koperasiKSP.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Riwayat")
public class Riwayat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PengajuanId")
    private Pengajuan pengajuanId;

    @Column(name = "Keterangan", nullable = false)
    private String keterangan;

    @Column(name = "Tanggal", nullable = false)
    private LocalDate tanggal;

    public Riwayat() {
    }
    public Riwayat(Long id, Pengajuan pengajuanId, String keterangan, LocalDate tanggal) {
        this.id = id;
        this.pengajuanId = pengajuanId;
        this.keterangan = keterangan;
        this.tanggal = tanggal;
    }

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