package com.example.oopsprojectbackend.product;

import com.example.oopsprojectbackend.cartItem.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.id = ?1")
    Optional<Product> findProductById(Long id);

    @Query("SELECT p FROM Product p WHERE p.category_id = ?1")
    Optional<Product[]> findProductsFromCategory(Long cid);

    @Query("SELECT p FROM Product p WHERE p.showstatus = ?1")
    Optional<Product[]> findProductsToShow(String st);

    @Query(value = "SELECT * FROM Product p WHERE SIMILARITY(p.name,?1) > 0.1 ORDER BY SIMILARITY(p.name,?1) DESC LIMIT 10", nativeQuery = true)
    Optional<Product[]> findProductsFromQuery(String query);


}
