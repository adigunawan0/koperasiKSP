package com.koperasiKSP.service;

import com.koperasiKSP.entity.Riwayat;
import com.koperasiKSP.repository.RiwayatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RiwayatServiceImpl implements RiwayatService{

    @Autowired
    private RiwayatRepository riwayatRepository;

    @Override
    public List<Riwayat> findAll() {
        return riwayatRepository.findAll();
    }

    @Override
    public Riwayat findById(Long id) {
        Optional<Riwayat> optionalRiwayat = riwayatRepository.findById(id);
        return optionalRiwayat.orElse(null);
    }

    @Override
    public void save(Riwayat riwayat) {
        riwayatRepository.save(riwayat);
    }

    @Override
    public void delete(Riwayat riwayat) {
        riwayatRepository.delete(riwayat);
    }

    @Override
    public void deleteById(Long id) {
        Riwayat entity = findById(id);
        delete(entity);
    }
}
