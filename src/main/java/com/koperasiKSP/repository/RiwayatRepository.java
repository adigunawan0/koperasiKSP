package com.koperasiKSP.repository;

import com.koperasiKSP.dto.riwayat.RiwayatDTO;
import com.koperasiKSP.entity.Riwayat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RiwayatRepository extends JpaRepository<Riwayat, Long> {
    @Query("""
            SELECT new com.koperasiKSP.dto.riwayat.RiwayatDTO(ri.id, acc.name, pen.nominal, ri.keterangan, ri.tanggal)
            FROM Riwayat AS ri
                JOIN ri.pengajuan AS pen
                JOIN pen.account AS acc
            WHERE acc.username LIKE %:username%
                AND acc.name LIKE %:nama%
            """)
    Page<RiwayatDTO> findDTOPages(String username, String nama, Pageable pageable);
}