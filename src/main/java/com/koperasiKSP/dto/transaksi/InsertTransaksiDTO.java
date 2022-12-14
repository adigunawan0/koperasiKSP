package com.koperasiKSP.dto.transaksi;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public class InsertTransaksiDTO{
    @NotNull(message = "Id Pengajuan tidak boleh null")
    private final Long pengajuanId;

    @NotNull(message = "Nominal tidak boleh null")
    private final BigDecimal nominal;

    @NotBlank(message = "Keterangan tidak boleh null")
    private final String keterangan;
    private final LocalDate tanggal;

    public InsertTransaksiDTO(Long pengajuanId, BigDecimal nominal, String keterangan) {
        this.pengajuanId = pengajuanId;
        this.nominal = nominal;
        this.keterangan = keterangan;
        this.tanggal = LocalDate.now();
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
