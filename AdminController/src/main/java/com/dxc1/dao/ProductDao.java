package com.dxc1.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dxc1.model.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
	

	List<Product> findByProductId(int productId);
}
