package com.example.oopsprojectbackend.wallet;

import com.example.oopsprojectbackend.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {

    Optional<Wallet> findByUid(Long uid);

    @Query("SELECT w FROM Wallet w WHERE w.uid = ?1 AND w.pin = ?2")
    Optional<Wallet> checkIfExists(Long uid, String pin);

    long deleteByUid(Long uid);

}
