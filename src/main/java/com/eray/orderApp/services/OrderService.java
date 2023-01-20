package com.eray.orderApp.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eray.orderApp.entities.Order;
import com.eray.orderApp.entities.Product;
import com.eray.orderApp.repositories.OrderRepository;
import com.eray.orderApp.response.OrderResponse;



@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	public List<OrderResponse> listExpensiveOrder(long orderPrice) {
		List<Order>list;
		list = orderRepository.listExpensiveOrders(orderPrice);
		return list.stream().map(o -> new OrderResponse(o)).collect(Collectors.toList());
	
	}

	public List<OrderResponse> listExpensiveOrderAvg(long orderPrice) {
		List<Order>list;
		list = orderRepository.listExpensiveOrdersAvg(orderPrice);
		return list.stream().map(o -> new OrderResponse(o)).collect(Collectors.toList());
	}

	public List<OrderResponse> listAllOrder() {
		List<Order> list;
		list = orderRepository.findAll();
		return list.stream().map(o -> new OrderResponse(o)).collect(Collectors.toList());
	}

	public List<OrderResponse> listCheapOrders(long orderPrice) {
		List<Order> list;
		list = orderRepository.listCheapOrders(orderPrice);
		return list.stream().map(o -> new OrderResponse(o)).collect(Collectors.toList());
	}

	public List<OrderResponse> filterOrdersByDate(String orderDate) {
		List<Order> list;
		list = orderRepository.filterOrdersByDate(orderDate);
		return list.stream().map(o -> new OrderResponse(o)).collect(Collectors.toList());
	}

	
	
}
