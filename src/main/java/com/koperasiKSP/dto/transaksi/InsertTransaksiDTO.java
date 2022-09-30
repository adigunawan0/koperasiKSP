package com.koperasiKSP.dto.transaksi;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class InsertTransaksiDTO{
    private final Long pengajuanIdId;
    private final BigDecimal nominal;
    private final String keterangan;
    private final LocalDate tanggal;

    public InsertTransaksiDTO(Long pengajuanIdId, BigDecimal nominal, String keterangan) {
        this.pengajuanIdId = pengajuanIdId;
        this.nominal = nominal;
        this.keterangan = keterangan;
        this.tanggal = LocalDate.now();
    }

    public Long getPengajuanIdId() {
        return pengajuanIdId;
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
