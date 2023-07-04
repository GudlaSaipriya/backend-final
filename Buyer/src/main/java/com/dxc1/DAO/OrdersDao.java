package com.dxc1.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dxc1.model.Order;

@Repository
public interface OrdersDao extends JpaRepository<Order, Integer>{
	
}
