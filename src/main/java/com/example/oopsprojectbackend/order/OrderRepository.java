package com.example.oopsprojectbackend.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT o FROM Order o WHERE o.id = ?1")
    Optional<Order> findOrderbyId(Long id);

    Optional<Order[]> findByOrderDate(LocalDate date);

    @Query(value = "SELECT o FROM Order o WHERE o.uid = ?1 ORDER BY o.date DESC", nativeQuery = true)
    Optional<Order[]> findByUid(Long uid);
}
