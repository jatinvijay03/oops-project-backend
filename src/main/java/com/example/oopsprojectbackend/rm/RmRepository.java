package com.example.oopsprojectbackend.rm;

import com.example.oopsprojectbackend.wallet.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RmRepository extends JpaRepository<Rm, Long> {

    @Query("SELECT r FROM Rm r WHERE r.id = ?1")
    Optional<Rm> findRmById(Long id);

    Optional<Rm> findByUid(Long uid);

    long deleteByUid(Long uid);

}
