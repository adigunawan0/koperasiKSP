package com.koperasiKSP.service;

import com.koperasiKSP.entity.Transaksi;
import com.koperasiKSP.repository.TransaksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransaksiServiceImpl implements TransaksiService{

    @Autowired
    private TransaksiRepository transaksiRepository;


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
}
