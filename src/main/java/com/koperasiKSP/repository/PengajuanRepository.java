package com.koperasiKSP.repository;

import com.koperasiKSP.dto.pengajuan.PengajuanDTO;
import com.koperasiKSP.entity.Pengajuan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PengajuanRepository extends JpaRepository<Pengajuan, Long> {

    @Query("""
            SELECT new com.koperasiKSP.dto.pengajuan.PengajuanDTO(pen.id, ac.username, ac.name, pen.nominal, pen.keterangan, pen.startDate, pen.endDate)
            FROM Pengajuan AS pen
                JOIN pen.account AS ac
            WHERE ac.username LIKE %:username%
                AND ac.name LIKE %:nama%
                """)
    Page<PengajuanDTO> getDTOpages(@Param("username") String username,
                                   @Param("nama") String nama,
                                   Pageable pageable);
}