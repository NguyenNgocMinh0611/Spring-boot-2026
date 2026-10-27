package com.springmasterclass.study.bai5.repository;

import com.springmasterclass.study.bai5.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
// cách 3 là có thêm cái JpaSpecificationExecutor<Product>
public interface ProductRepository extends JpaRepository<Product,Long>, JpaSpecificationExecutor<Product> {

    // cách 2 làm pagination
    // Annotation này giúp viết các cái SQL theo kiểu native SQL hay sử dụng jpa
    // này là cách viết jpa
    @Query(value = "SELECT p FROM Product p WHERE p.status= 'ACTIVE' AND p.category = :category",
    countQuery = "SELECT count(p) FROM Product p WHERE p.status= 'ACTIVE' AND p.category = :category")
    Page<Product> findActiveByCategory(@Param("category") String caregory, Pageable pageable);


}
