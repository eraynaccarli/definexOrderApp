package com.eray.orderApp.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long productId;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "brand")
	private String brand;
	
	@Column(name = "product_price")
	private double productPrice;
	
	@ManyToMany(mappedBy = "products")
	private Set<Order> orders;
	
	
}
