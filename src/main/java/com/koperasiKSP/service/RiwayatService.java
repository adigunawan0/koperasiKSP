package com.koperasiKSP.service;

import com.koperasiKSP.entity.Riwayat;

import java.util.List;

public interface RiwayatService {
    List<Riwayat> findAll();
    Riwayat findById(Long id);
    void save(Riwayat riwayat);
    void delete(Riwayat riwayat);
    void deleteById(Long id);
}
