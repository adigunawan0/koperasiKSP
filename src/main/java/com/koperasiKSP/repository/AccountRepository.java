package com.koperasiKSP.repository;

import com.koperasiKSP.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccountRepository extends JpaRepository<Account, String> {

    @Query("""
            SELECT COUNT(ac)
            FROM Account AS ac
            WHERE ac.email = :email
            """)
    Long countByEmail(@Param("email") String email);

    @Query("""
            SELECT ac
            FROM Account AS ac
            WHERE ac.name = :nama
            """)
    Account findByName(@Param("nama") String nama);

    @Query("""
            SELECT ac
            FROM Account AS ac
            WHERE ac.name LIKE %:nama%
                AND ac.username LIKE %:username%""")
    Page<Account> getDTOPages(@Param("username") String username,
                              @Param("nama") String nama,
                              Pageable pageable);
}