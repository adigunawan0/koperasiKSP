package com.koperasiKSP.repository;

import com.koperasiKSP.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccountRepository extends JpaRepository<Account, String> {

    @Query("""
            SELECT COUNT(*)
            FROM Account
            WHERE Account.username = :email
            """)
    Long countByEmail(@Param("email") String email);
}