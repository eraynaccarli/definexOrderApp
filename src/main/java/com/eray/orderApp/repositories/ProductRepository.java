package com.eray.orderApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eray.orderApp.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
