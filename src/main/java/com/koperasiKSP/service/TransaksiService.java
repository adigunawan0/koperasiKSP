package com.koperasiKSP.service;

import com.koperasiKSP.dto.transaksi.InsertTransaksiDTO;
import com.koperasiKSP.dto.transaksi.TransaksiDTO;
import com.koperasiKSP.dto.transaksi.UpdateTransaksiDTO;
import com.koperasiKSP.entity.Transaksi;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TransaksiService {
    List<Transaksi> findAll();
    Transaksi findById(Long id);
    void save(Transaksi transaksi);
    void delete(Transaksi transaksi);
    void deleteById(Long id);
    void insert(InsertTransaksiDTO dto);
    void update(Long id, UpdateTransaksiDTO dto);

    Page<TransaksiDTO> transaksiPages(String nama, String username, int page);
}
