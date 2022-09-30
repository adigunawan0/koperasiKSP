package com.koperasiKSP.rest;

import com.koperasiKSP.dto.riwayat.InsertRiwayatDTO;
import com.koperasiKSP.dto.riwayat.RiwayatDTO;
import com.koperasiKSP.dto.riwayat.UpdateRiwayatDTO;
import com.koperasiKSP.service.RiwayatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/riwayat")
public class RiwayatController {

    @Autowired
    private RiwayatService riwayatService;

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody InsertRiwayatDTO dto){
        riwayatService.insert(dto);
        return new ResponseEntity<>("Riwayat berhasil dibuat", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        try {
            riwayatService.deleteById(id);
            return new ResponseEntity<>("Riwayat dengan ID: " + id + " berhasil dihapus", HttpStatus.ACCEPTED);
        } catch (Exception exception){
            return new ResponseEntity<>("Riwayat ID tidak ditemukan!", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@RequestBody UpdateRiwayatDTO dto,
                                         @PathVariable Long id){
        try{
            riwayatService.update(id, dto);
            return new ResponseEntity<>("Riwayat dengan ID: " + id + " berhasil diupdate", HttpStatus.ACCEPTED);
        } catch (Exception ex){
            return new ResponseEntity<>("Riwayat tidak dapat diupdate", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<Page<RiwayatDTO>> index(@RequestParam(defaultValue = "1") int page,
                                                  @RequestParam(defaultValue = "") String username,
                                                  @RequestParam(defaultValue = "") String nama){

        Page<RiwayatDTO> riwayatDTOPage = riwayatService.getPages(username, nama, page);
        return new ResponseEntity<>(riwayatDTOPage, HttpStatus.OK);
    }
}
