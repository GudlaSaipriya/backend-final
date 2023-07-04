package com.dxc1.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dxc1.execption.OrderException;
import com.dxc1.model.Order;
import com.dxc1.model.Product;
import com.dxc1.service.OrderService;

@RestController
//@RequestMapping("/orderbybuyer")
public class OrderController {
	
	@GetMapping("/greet")
    public String welcome(){
        return "Buyer page is working";
    }
	
	@Autowired
	private OrderService orderservice;
	
	@PostMapping("/order")
	public ResponseEntity<?> orderproduct(@RequestBody Order orders) throws OrderException {
		return new ResponseEntity<>(orderservice.order(orders), HttpStatus.CREATED);
	}
	
	@GetMapping("allorders")
    public List<Order> getOrders(){
        return orderservice.getAllOrders();
    }
	
	
	
	
	
	@Autowired
	private RestTemplate restTemplate;	
	
	@GetMapping("/buyer/getAllProducts")
	public List<Product>getAllProducts(){
		List<Product> pro = null;
		
		String url = "http://localhost:8097/getAllProducts";
		
		try {
			pro =restTemplate.getForObject(url,List.class);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return pro;
	}
	
	
	
	
	
	
	
	
}