package com.softtek.academy.services;

import java.util.List;

import com.softtek.academy.domain.Order;

public interface OrderService {
	
	public List<Order> getAllOrders();
	
	public Order getOrderById(Long id);
	
	public boolean deteleOrder();

}
