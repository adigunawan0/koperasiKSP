package com.koperasiKSP.dto.pengajuan;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class PengajuanDTO implements Serializable {
    private final Long id;
    private final String username;
    private final String name;
    private final BigDecimal nominal;
    private final String keterangan;
    private final LocalDate startDate;
    private final LocalDate endDate;

    public PengajuanDTO(Long id, String username, String name, BigDecimal nominal, String keterangan, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.nominal = nominal;
        this.keterangan = keterangan;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
