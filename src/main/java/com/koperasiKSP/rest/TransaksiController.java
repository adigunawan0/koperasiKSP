package com.koperasiKSP.rest;

import com.koperasiKSP.dto.transaksi.InsertTransaksiDTO;
import com.koperasiKSP.service.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/transaksi")
public class TransaksiController {

    @Autowired
    private TransaksiService transaksiService;

    @PostMapping
    public ResponseEntity<String> insert(@Valid @RequestBody InsertTransaksiDTO dto){
        transaksiService.insert(dto);
        return new ResponseEntity<>("Transaksi berhasil dibuat!", HttpStatus.CREATED);
    }
}
