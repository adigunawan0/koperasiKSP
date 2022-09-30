package com.koperasiKSP.dto.pengajuan;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class InsertPengajuanDTO {

    @NotBlank(message = "Nama tidak boleh kosong")
    private final String nama;

    @NotNull(message = "Nominal tidak boleh kosong")
    @Min(value = 1000000, message = "Nominal tidak boleh lebih kecil dari Rp. 1.000.000")
    private final BigDecimal nominal;

    @NotBlank(message = "Keterangan tidak boleh kosong")
    private final String keterangan;

    @NotNull(message = "Durasi tidak boleh kosong")
    private final int durasi;

    public InsertPengajuanDTO(String nama, BigDecimal nominal, String keterangan, int durasi) {
        this.nama = nama;
        this.nominal = nominal;
        this.keterangan = keterangan;
        this.durasi = durasi;
    }

    public String getNama() {
        return nama;
    }

    public BigDecimal getNominal() {
        return nominal;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public int getDurasi() {
        return durasi;
    }
}
