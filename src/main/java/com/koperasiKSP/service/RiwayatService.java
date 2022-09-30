package com.koperasiKSP.service;

import com.koperasiKSP.dto.riwayat.InsertRiwayatDTO;
import com.koperasiKSP.dto.riwayat.RiwayatDTO;
import com.koperasiKSP.dto.riwayat.UpdateRiwayatDTO;
import com.koperasiKSP.entity.Riwayat;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RiwayatService {
    List<Riwayat> findAll();
    Riwayat findById(Long id);
    void save(Riwayat riwayat);
    void delete(Riwayat riwayat);
    void deleteById(Long id);
    void insert(InsertRiwayatDTO dto);
    void update(Long id, UpdateRiwayatDTO dto);

    Page<RiwayatDTO> getPages(String username, String nama, int page);
}
