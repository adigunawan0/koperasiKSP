package com.koperasiKSP.dto.transaksi;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class UpdateTransaksiDTO {

    private final BigDecimal nominal;
    private final String keterangan;
    private final LocalDate tanggal;

    public UpdateTransaksiDTO(BigDecimal nominal, String keterangan, LocalDate tanggal) {
        this.nominal = nominal;
        this.keterangan = keterangan;
        this.tanggal = LocalDate.now();
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
