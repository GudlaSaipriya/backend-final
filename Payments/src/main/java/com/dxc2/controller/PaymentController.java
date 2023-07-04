package com.dxc2.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.dxc2.exception.DuplicatePaymentIdException;
import com.dxc2.model.Payment;
import com.dxc2.service.PaymentService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/pay")
public class PaymentController {

	@Autowired
	private PaymentService service;
	
	@PostMapping("/payment")
	public void createPayment(@RequestBody Payment payment) throws DuplicatePaymentIdException{
		service.addPayment(payment);

	}
	
	
	
	@GetMapping("/payment")
	public List<Payment> getAllPayments(){    

        List<Payment> pay= service.AllPayments();

        return pay;
	}
	

	
	
	//	try {
//	service.addPayment(payment);
//} catch (DuplicatePaymentIDException e) {
//	System.out.println("\nCannot add the payment\n");
//	System.out.println(e);
////	e.printStackTrace();
//}

	
	//public Payment getPayment(int id)  {
		
		//Optional<Payment> p = Optional.of(service.getPayment(id));
		
		//if(p.isPresent()) {
			//	return p.get();
		//} else {
			//System.out.println("Payment Doesn't Exist");
			//return null;
		//}
		
//		Payment payment = null;
//		try {
//			payment = service.getPayment(id);
//		} catch (PaymentDoesNotExistException e) {
//			System.out.println("\nCannot find the hotel\n");
//			System.out.println(e);
//			return null;
////			e.printStackTrace();
//		}
//		return payment;
	}
