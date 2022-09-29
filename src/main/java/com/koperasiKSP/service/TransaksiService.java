package com.koperasiKSP.service;

import com.koperasiKSP.entity.Transaksi;

import java.util.List;

public interface TransaksiService {
    List<Transaksi> findAll();
    Transaksi findById(Long id);
    void save(Transaksi transaksi);
    void delete(Transaksi transaksi);
    void deleteById(Long id);
}
