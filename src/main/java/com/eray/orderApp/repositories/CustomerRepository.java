package com.eray.orderApp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.eray.orderApp.entities.Customer;
import com.eray.orderApp.entities.Order;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	@Query(value = "SELECT customer_id,name,surname FROM customers WHERE name like ?% ", nativeQuery = true)
	List<Customer> searchCustomer(String text);
}

	
