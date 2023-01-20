package com.eray.orderApp.response;

import java.util.Set;

import com.eray.orderApp.entities.Order;
import com.eray.orderApp.entities.Product;
import lombok.Data;
@Data
public class OrderResponse {

	private Long id;
	
	private String orderName;

	private double orderPrice;
	
	private String orderDate;
	
	private Set<Product> products;
	
	private String customerName;;
	
	public OrderResponse(Order entity) {
		this.id = entity.getOrderId();
		this.orderName = entity.getOrderName();
		this.orderDate = entity.getOrderDate();
		this.orderPrice = entity.getOrderPrice();
		this.products = entity.getProducts();
		this.customerName = entity.getCustomer().getName();
	}
	
}
