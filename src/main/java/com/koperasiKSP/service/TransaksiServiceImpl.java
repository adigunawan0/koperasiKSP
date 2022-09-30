package com.koperasiKSP.service;

import com.koperasiKSP.dto.transaksi.InsertTransaksiDTO;
import com.koperasiKSP.entity.Pengajuan;
import com.koperasiKSP.entity.Transaksi;
import com.koperasiKSP.repository.PengajuanRepository;
import com.koperasiKSP.repository.TransaksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransaksiServiceImpl implements TransaksiService{

    @Autowired
    private TransaksiRepository transaksiRepository;

    @Autowired
    private PengajuanRepository pengajuanRepository;


    @Override
    public List<Transaksi> findAll() {
        return transaksiRepository.findAll();
    }

    @Override
    public Transaksi findById(Long id) {
        Optional<Transaksi> optionalTransaksi = transaksiRepository.findById(id);
        return optionalTransaksi.orElse(null);
    }

    @Override
    public void save(Transaksi transaksi) {
        transaksiRepository.save(transaksi);
    }

    @Override
    public void delete(Transaksi transaksi) {
        transaksiRepository.delete(transaksi);
    }

    @Override
    public void deleteById(Long id) {
        Transaksi entity = findById(id);
        transaksiRepository.delete(entity);
    }

    @Override
    public void insert(InsertTransaksiDTO dto) {
        Optional<Pengajuan> entity = pengajuanRepository.findById(dto.getPengajuanIdId());
        save(new Transaksi(
                entity.orElse(null),
                dto.getNominal(),
                dto.getKeterangan(),
                dto.getTanggal()
        ));
    }
}
