package com.eray.orderApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.eray.orderApp.response.OrderResponse;
import com.eray.orderApp.services.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping("/listExpensiveOrder/{orderPrice}")
	public List<OrderResponse>listExpensiveOrder(@PathVariable long orderPrice) {
		return this.orderService.listExpensiveOrder(orderPrice);
	}
	
	@GetMapping("/listExpensiveOrderAvg/{orderPrice}")
	public List<OrderResponse>listExpensiveOrderAvg(@PathVariable long orderPrice) {
		return this.orderService.listExpensiveOrderAvg(orderPrice);
	}
	
	@GetMapping("/listCheapOrders/{orderPrice}")
	public List<OrderResponse>listCheapOrders(@PathVariable long orderPrice) {
		return this.orderService.listCheapOrders(orderPrice);
	}
	
	@GetMapping("/listAllOrders")
	public List<OrderResponse> listAllOrders(){
		return this.orderService.listAllOrder();
	}
	
	@GetMapping("/filterOrdersByDate/{orderDate}")
	public List<OrderResponse> filterOrdersByDate(@PathVariable String orderDate){
		return this.orderService.filterOrdersByDate(orderDate);
	}
}

