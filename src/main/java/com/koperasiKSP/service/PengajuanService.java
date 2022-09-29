package com.koperasiKSP.service;

import com.koperasiKSP.dto.pengajuan.InsertPengajuanDTO;
import com.koperasiKSP.dto.pengajuan.UpdatePengajuanDTO;
import com.koperasiKSP.entity.Pengajuan;

import java.util.List;

public interface PengajuanService {
    List<Pengajuan> findAll();
    Pengajuan findById(Long id);
    void save(Pengajuan pengajuan);
    void delete(Pengajuan pengajuan);
    void deleteById(Long id);
    void insert(InsertPengajuanDTO dto);
    void update(Long id, UpdatePengajuanDTO dto);
}
