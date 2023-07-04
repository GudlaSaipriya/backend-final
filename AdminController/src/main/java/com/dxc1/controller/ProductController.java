package com.dxc1.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;


import com.dxc1.exception.ProductExistsException;


import com.dxc1.model.Product;

import com.dxc1.service.ProductService;



@RestController
//@RequestMapping("/pro")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	
	//@PostMapping({"/createProduct"})
	//public Product addNewProduct(@RequestBody Product product) {
		//return productService.createProduct(product);
		
	//}
	
	@GetMapping("/seller/greet")

    public String welcome(){

        return "admin page is working";

    }
	
	@PostMapping("/seller/createProduct")
    public ResponseEntity<?> createProduct(@RequestBody Product product) throws ProductExistsException {
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
    }
	
	@GetMapping({"getAllProducts"})
	public List<Product>getAllProducts(){
		return productService.getAllProducts();
		
	}
	
	@PutMapping("/seller/products/{id}")

    public void updateProduct(@PathVariable("id") int id,@RequestBody Product product) {

        productService.updateProduct(id, product);

    }
	@DeleteMapping("/seller/products/{id}")

    public void deleteProduct(@PathVariable("id") int id) {

        productService.deleteProduct(id);

     }
	
	@GetMapping("/products/{id}") 
    public List<Product> getProductById(@PathVariable("id") int id) { 
    	return productService.getProductById(id);
    }
	
//	@GetMapping("/products/{productName}")
//
//    public List<Product> getByProductname(@PathVariable String productName) {
//
//        return productService.getAllProductByProductname(productName);
//
// 
//
//    }
	
	 
	 
	 
	
	// @Autowired
		//private RestTemplate restTemplate;	
		
		//@GetMapping("/seller/allorders")
//		public List<Order> getallOrders(){
//			List<Order> ord = null;
//			
//			String url = "http://localhost:8098/allorders";
//			
//			try {
//				ord =restTemplate.getForObject(url,List.class);
//			}catch(Exception ex) {
//				ex.printStackTrace();
//			}
//			return ord;
//		}
//		
//		
//		@GetMapping("/orderbybuyer/{productName}")
//		public List<Order> getallOrdersbyProduct(@PathVariable String productName){
//			List<Order> ord = null;
//			
//			String url = "http://localhost:8098/orderbybuyer/"+productName;
//			
//			try {
//				ord =restTemplate.getForObject(url,List.class);
//			}catch(Exception ex) {
//				ex.printStackTrace();
//			}
//			return ord;
//		}
//		
//		
//		
//		
//		
//		@GetMapping("/user/reviews/allratings")
//		public List<Rating> getAllRatings(){    
//
//	        //List<Rating> rating = service.AllRatings();
//
//	        //return rating;
//			List<Rating> rate =null;
//			String url="http://localhost:8082/user/reviews/allratings";
//			try {
//				rate =restTemplate.getForObject(url,List.class);
//			}catch(Exception ex) {
//				ex.printStackTrace();
//			}
//			return rate;
//		}
//		
//		
//		@GetMapping("/pay/getallPayment")
//		public List<Payment> getAllPayments(){ 
//			List<Payment> payes=null;
//			String url="http://localhost:9940/pay/getallPayment";
//
//			try {
//				payes =restTemplate.getForObject(url,List.class);
//			}catch(Exception ex) {
//				ex.printStackTrace();
//			}
//
//	        return payes;
		//}
}
		
		
		
		
		
		
	 
	 
	 
	 
	 

