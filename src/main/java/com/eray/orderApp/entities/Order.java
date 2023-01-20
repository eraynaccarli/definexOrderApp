package com.eray.orderApp.entities;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "orders")
@Data
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "order_id")
	private long orderId;
	
	@Column(name = "order_name")
	private String orderName;
	
	@Column(name = "order_price")
	private double orderPrice;
	
	@Column(name = "order_date")
	private String orderDate;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
	  name = "products_order", 
	  joinColumns = @JoinColumn(name = "orderId"), 
	  inverseJoinColumns = @JoinColumn(name = "productId"))	
	private Set<Product> products;
	
	@ManyToOne
	@JoinColumn(name = "customerId")
	@JsonIgnore
	private Customer customer;
	
	
}
