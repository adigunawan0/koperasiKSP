package com.koperasiKSP.dto.riwayat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class RiwayatDTO {
    private final Long id;
    private final String name;
    private final BigDecimal nominal;
    private final String keterangan;
    private final LocalDate tanggal;

    public RiwayatDTO(Long id, String name, BigDecimal nominal, String keterangan, LocalDate tanggal) {
        this.id = id;
        this.name = name;
        this.nominal = nominal;
        this.keterangan = keterangan;
        this.tanggal = tanggal;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getNominal() {
        return nominal;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public LocalDate getTanggal() {
        return tanggal;
    }
}
