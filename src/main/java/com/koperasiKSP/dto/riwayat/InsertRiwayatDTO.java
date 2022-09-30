package com.koperasiKSP.dto.riwayat;

import java.math.BigDecimal;
import java.time.LocalDate;

public class InsertRiwayatDTO {
    private final Long pengajuanId;
    private final String keterangan;
    private final LocalDate tanggal;

    public InsertRiwayatDTO(Long pengajuanId, String keterangan, LocalDate tanggal) {
        this.pengajuanId = pengajuanId;
        this.keterangan = keterangan;
        this.tanggal = LocalDate.now();
    }

    public Long getPengajuanId() {
        return pengajuanId;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public LocalDate getTanggal() {
        return tanggal;
    }
}
