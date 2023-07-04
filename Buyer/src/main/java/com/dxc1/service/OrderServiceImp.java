package com.dxc1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc1.DAO.OrdersDao;
import com.dxc1.execption.OrderException;
import com.dxc1.model.Order;

@Service
public class OrderServiceImp implements OrderService {

	
	@Autowired
	   private OrdersDao ordersDAO;
	
	

	@Override
	public Order order(Order order) throws OrderException {
		// TODO Auto-generated method stub
		return ordersDAO.save(order);
	}
	
	public List<Order> getAllOrders() {
		List<Order> ordersList = ordersDAO.findAll();
        if(ordersList.size()>0)
            return ordersList;
        else
            return null;

	}

}
