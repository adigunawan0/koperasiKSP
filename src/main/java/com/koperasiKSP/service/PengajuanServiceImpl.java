package com.koperasiKSP.service;

import com.koperasiKSP.entity.Pengajuan;
import com.koperasiKSP.repository.PengajuanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PengajuanServiceImpl implements PengajuanService{

    @Autowired
    private PengajuanRepository pengajuanRepository;

    @Override
    public List<Pengajuan> findAll() {
        return pengajuanRepository.findAll();
    }

    @Override
    public Pengajuan findById(Long id) {
        Optional<Pengajuan> optionalPengajuan = pengajuanRepository.findById(id);
        return optionalPengajuan.orElse(null);
    }

    @Override
    public void save(Pengajuan pengajuan) {
        pengajuanRepository.save(pengajuan);
    }

    @Override
    public void delete(Pengajuan pengajuan) {
        pengajuanRepository.delete(pengajuan);
    }

    @Override
    public void deleteById(Long id) {
        Pengajuan entity = findById(id);
        delete(entity);
    }
}
