package com.eray.orderApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eray.orderApp.entities.Customer;
import com.eray.orderApp.response.CustomerResponse;
import com.eray.orderApp.services.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	public List<CustomerResponse> listAllCustomer(){
		return this.customerService.listAllCustomer();
	}
	
	@GetMapping("/{text}")
	public List<CustomerResponse> searchCustomer(@PathVariable String text){
		return this.customerService.searchCustomer(text);
	}
	
	@PostMapping
	public Customer addCustomer(@RequestBody Customer customer) {
		return this.customerService.addCustomer(customer);
	}
}
