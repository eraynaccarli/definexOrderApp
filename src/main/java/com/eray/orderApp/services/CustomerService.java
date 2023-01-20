package com.eray.orderApp.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eray.orderApp.entities.Customer;
import com.eray.orderApp.repositories.CustomerRepository;
import com.eray.orderApp.response.CustomerResponse;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public List<CustomerResponse> listAllCustomer(){
		List<Customer>list;
		list = customerRepository.findAll();
		return list.stream().map(c -> new CustomerResponse(c)).collect(Collectors.toList());
	}

	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public List<CustomerResponse> searchCustomer(String text) {
		List<Customer>list;
		list = customerRepository.searchCustomer(text);
		return list.stream().map(c -> new CustomerResponse(c)).collect(Collectors.toList());
	}

}
