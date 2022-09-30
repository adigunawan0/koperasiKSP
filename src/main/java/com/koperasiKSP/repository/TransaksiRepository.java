package com.koperasiKSP.repository;

import com.koperasiKSP.dto.transaksi.TransaksiDTO;
import com.koperasiKSP.entity.Transaksi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TransaksiRepository extends JpaRepository<Transaksi, Long> {
    @Query("""
            SELECT new com.koperasiKSP.dto.transaksi.TransaksiDTO(tr.id, acc.name, pen.id, tr.nominal, tr.keterangan, tr.tanggal)
            FROM Transaksi AS tr
                JOIN tr.pengajuan AS pen
                JOIN pen.account AS acc
            WHERE acc.name LIKE %:nama%
                AND acc.username LIKE %:username%
            """)
    Page<TransaksiDTO> findDTOPages(@Param("nama") String nama,
                                    @Param("username") String username,
                                    Pageable pageable);
}