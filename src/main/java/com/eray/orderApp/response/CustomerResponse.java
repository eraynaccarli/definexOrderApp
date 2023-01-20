package com.eray.orderApp.response;

import java.util.List;

import com.eray.orderApp.entities.Customer;
import com.eray.orderApp.entities.Order;

import lombok.Data;

@Data
public class CustomerResponse {
	
	private long customerId;
	
	private String name;

	private String surname;


	
	public CustomerResponse(Customer entity) {
		this.customerId = entity.getCustomerId();
		this.name= entity.getName();
		this.surname= entity.getSurname();
	}
	
}
