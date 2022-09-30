package com.koperasiKSP.dto.transaksi;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransaksiDTO{
    private final Long id;
    private final String name;
    private final Long pengajuanId;
    private final BigDecimal nominal;
    private final String keterangan;
    private final LocalDate tanggal;

    public TransaksiDTO(Long id, String name, Long pengajuanId, BigDecimal nominal, String keterangan, LocalDate tanggal) {
        this.id = id;
        this.name = name;
        this.pengajuanId = pengajuanId;
        this.nominal = nominal;
        this.keterangan = keterangan;
        this.tanggal = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getPengajuanId() {
        return pengajuanId;
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
