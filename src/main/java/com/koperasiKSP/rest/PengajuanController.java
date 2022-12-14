package com.koperasiKSP.rest;

import com.koperasiKSP.dto.pengajuan.InsertPengajuanDTO;
import com.koperasiKSP.dto.pengajuan.PengajuanDTO;
import com.koperasiKSP.dto.pengajuan.UpdatePengajuanDTO;
import com.koperasiKSP.service.PengajuanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/pengajuan")
public class PengajuanController {

    @Autowired
    private PengajuanService pengajuanService;

    // Grant Access: Member
    @PostMapping
    public ResponseEntity<String> insert(@Valid @RequestBody InsertPengajuanDTO dto){

        pengajuanService.insert(dto);
        return new ResponseEntity<>("Berhasil membuat pengajuan atas nama " + dto.getNama() + " dengan nominal " + dto.getNominal(), HttpStatus.CREATED);
    }

    // Grant Access: Admin
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        try{
            pengajuanService.deleteById(id);
            return new ResponseEntity<>("pengajuan berhasil dihapus!", HttpStatus.ACCEPTED);

        } catch (Exception ex){
            return new ResponseEntity<>("pengajuan gagal dihapus!", HttpStatus.BAD_REQUEST);
        }
    }

    // Grant Access: Admin
    @PutMapping("/{id}")
    public ResponseEntity<String> update(@RequestBody UpdatePengajuanDTO dto,
                                         @PathVariable Long id){
        try{
            pengajuanService.update(id, dto);
            return new ResponseEntity<>("Pengajuan berhasil diupdate!", HttpStatus.ACCEPTED);
        }
        catch (Exception ex){
            return new ResponseEntity<>("Pengajuan tidak ditemukan", HttpStatus.NOT_FOUND);
        }
    }

    // Grant Access: Admin can get All, Member using principal as username parameter
    @GetMapping
    public ResponseEntity<Page<PengajuanDTO>> index(@RequestParam(defaultValue = "1") int page,
                                                    @RequestParam(defaultValue = "") String username,
                                                    @RequestParam(defaultValue = "") String nama){
        Page<PengajuanDTO> pengajuanPage = pengajuanService.findPages(username, nama, page);
        return new ResponseEntity<>(pengajuanPage, HttpStatus.OK);
    }

}
