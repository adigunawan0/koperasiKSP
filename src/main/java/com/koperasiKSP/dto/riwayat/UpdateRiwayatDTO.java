package com.koperasiKSP.dto.riwayat;

import java.io.Serializable;
import java.time.LocalDate;

public class UpdateRiwayatDTO {
    private final String keterangan;
    private final LocalDate tanggal;

    public UpdateRiwayatDTO(String keterangan, LocalDate tanggal) {
        this.keterangan = keterangan;
        this.tanggal = LocalDate.now();
    }

    public String getKeterangan() {
        return keterangan;
    }

    public LocalDate getTanggal() {
        return tanggal;
    }
}
