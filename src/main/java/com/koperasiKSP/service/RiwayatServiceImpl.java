package com.koperasiKSP.service;

import com.koperasiKSP.dto.riwayat.InsertRiwayatDTO;
import com.koperasiKSP.dto.riwayat.RiwayatDTO;
import com.koperasiKSP.dto.riwayat.UpdateRiwayatDTO;
import com.koperasiKSP.entity.Pengajuan;
import com.koperasiKSP.entity.Riwayat;
import com.koperasiKSP.repository.PengajuanRepository;
import com.koperasiKSP.repository.RiwayatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RiwayatServiceImpl implements RiwayatService{

    @Autowired
    private RiwayatRepository riwayatRepository;

    @Autowired
    private PengajuanRepository pengajuanRepository;

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

    @Override
    public void insert(InsertRiwayatDTO dto) {
        Optional<Pengajuan> optionalPengajuan = pengajuanRepository.findById(dto.getPengajuanId());
        save(new Riwayat(
                optionalPengajuan.orElse(null),
                dto.getKeterangan(),
                dto.getTanggal()
        ));
    }

    @Override
    public void update(Long id, UpdateRiwayatDTO dto) {
        Riwayat entity = findById(id);

        entity.setKeterangan(dto.getKeterangan());
        entity.setTanggal(dto.getTanggal());

        save(entity);
    }

    @Override
    public Page<RiwayatDTO> getPages(String username, String nama, int page) {
        Pageable pageable = PageRequest.of(page-1, 3, Sort.by("id"));
        return riwayatRepository.findDTOPages(username, nama, pageable);
    }
}
