package com.dxc1.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dxc1.dao.ProductDao;
import com.dxc1.exception.ProductExistsException;
import com.dxc1.model.Product;

@Service
public class ProductService implements ProductSeviceInterface{
	
	@Autowired
	private ProductDao productDao;
	
	

	//public Product createProduct(Product product) {
		// TODO Auto-generated method stub
	//	return productDao.save(product);
	//}
	
	public Product createProduct(Product product) throws ProductExistsException{
		Optional<Product> createproduct = productDao.findById(product.getProductId());
		//System.out.println("getting data from db:"+createproduct);
		if(createproduct.isPresent())
			throw new ProductExistsException();
		else
			return productDao.save(product);
	}
	
	public List<Product> getAllProducts(){
		List<Product> products = productDao.findAll();
		System.out.println("getting data from db:"+products);
		return products;

		//return productDao.findAll();
		
	}
	
	public void updateProduct(int id,Product product) {
		productDao.findById(id).get();
         productDao.save(product);
    }

    public void deleteProduct(int id)  {

    	productDao.deleteById(id);
    }
    
    public List<Product> getProductById(int productId) { 
    	
    	List<Product> products = productDao.findByProductId(productId);
		System.out.println("getting data from db:"+products);
		return products;
    	
    	//return productDao.findByProductId(productId);
    }
    
    


    
   // public List<Product> getAllProductByName(String productName) {
	//	return productDao.findByproductName(productName);
	//}
	
}

