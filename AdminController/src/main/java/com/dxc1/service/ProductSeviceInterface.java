package com.dxc1.service;

import java.util.List;

import com.dxc1.exception.ProductExistsException;
import com.dxc1.model.Product;

public interface ProductSeviceInterface {
	public Product createProduct(Product product) throws ProductExistsException;
	public List<Product> getAllProducts();
	public void updateProduct(int id,Product product);
	public void deleteProduct(int id);
	public List<Product> getProductById(int productId);


}
