package com.koperasiKSP.service;

import com.koperasiKSP.entity.Pengajuan;

import java.util.List;

public interface PengajuanService {
    List<Pengajuan> findAll();
    Pengajuan findById(Long id);
    void save(Pengajuan pengajuan);
    void delete(Pengajuan pengajuan);
    void deleteById(Long id);
}
