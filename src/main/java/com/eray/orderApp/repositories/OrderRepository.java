package com.eray.orderApp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.eray.orderApp.entities.Order;
import com.eray.orderApp.response.OrderResponse;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
	@Query(value = "SELECT * FROM orders WHERE order_price > ?1", nativeQuery = true)
	List<Order> listExpensiveOrders(Long orderPrice);
	
	@Query(value = "SELECT order_id,AVG(order_price) as avg_order,order_date FROM orders WHERE order_price > ?1", nativeQuery = true)
	List<Order> listExpensiveOrdersAvg(Long orderPrice);
	
	@Query(value = "SELECT * FROM orders WHERE order_price < ?1", nativeQuery = true)
	List<Order> listCheapOrders(Long orderPrice);

	@Query(value = "SELECT order_id,SUM(order_price) as sum_orders, order_date FROM orders WHERE order_date IN (?)", nativeQuery = true)
	List<Order> filterOrdersByDate(String orderDate);
	
}

