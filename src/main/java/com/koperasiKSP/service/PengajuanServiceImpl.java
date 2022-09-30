package com.koperasiKSP.service;

import com.koperasiKSP.dto.pengajuan.InsertPengajuanDTO;
import com.koperasiKSP.dto.pengajuan.PengajuanDTO;
import com.koperasiKSP.dto.pengajuan.UpdatePengajuanDTO;
import com.koperasiKSP.entity.Account;
import com.koperasiKSP.entity.Pengajuan;
import com.koperasiKSP.repository.AccountRepository;
import com.koperasiKSP.repository.PengajuanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PengajuanServiceImpl implements PengajuanService{

    @Autowired
    private PengajuanRepository pengajuanRepository;

    @Autowired
    private AccountRepository accountRepository;

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

    @Override
    public void insert(InsertPengajuanDTO dto) {
        Account theAccount = accountRepository.findByName(dto.getNama());
        save(new Pengajuan(
                theAccount,
                dto.getNominal(),
                dto.getKeterangan(),
                LocalDate.now(),
                LocalDate.now().plusMonths(dto.getDurasi())
        ));
    }

    @Override
    public void update(Long id, UpdatePengajuanDTO dto) {
        Pengajuan pengajuan = findById(id);

        if (dto.getNominal() != null){
            pengajuan.setNominal(dto.getNominal());
        }
        if (dto.getKeterangan() != null){
            pengajuan.setKeterangan(dto.getKeterangan());
        }

        save(pengajuan);
    }

    @Override
    public Page<PengajuanDTO> findPages(String username, String nama, int page) {
        Pageable pageable = PageRequest.of(page-1, 3, Sort.by("id"));
        return pengajuanRepository.getDTOpages(username, nama, pageable);
    }
}
