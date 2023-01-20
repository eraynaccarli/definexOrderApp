package com.eray.orderApp.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "customers")
@Data
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long customerId;

	@Column(name = "name")
	private String name;
	
	@Column(name = "surname")
	private String surname;
	
	@JsonIgnore
	@OneToMany(mappedBy = "customer")
	private List<Order> orders;
	
	
}
