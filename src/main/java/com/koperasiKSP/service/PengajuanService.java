package com.koperasiKSP.service;

import com.koperasiKSP.dto.pengajuan.InsertPengajuanDTO;
import com.koperasiKSP.dto.pengajuan.PengajuanDTO;
import com.koperasiKSP.dto.pengajuan.UpdatePengajuanDTO;
import com.koperasiKSP.entity.Pengajuan;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PengajuanService {
    List<Pengajuan> findAll();
    Pengajuan findById(Long id);
    void save(Pengajuan pengajuan);
    void delete(Pengajuan pengajuan);
    void deleteById(Long id);
    void insert(InsertPengajuanDTO dto);
    void update(Long id, UpdatePengajuanDTO dto);
    Page<PengajuanDTO> findPages(String username, String nama, int page);
}
