package com.koperasiKSP.dto.pengajuan;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

public class UpdatePengajuanDTO{

    private BigDecimal nominal;
    private String keterangan;

    public UpdatePengajuanDTO(BigDecimal nominal, String keterangan) {
        this.nominal = nominal;
        this.keterangan = keterangan;
    }

    public BigDecimal getNominal() {
        return nominal;
    }

    public String getKeterangan() {
        return keterangan;
    }
}
