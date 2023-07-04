package com.dxc2.service;
import java.util.List;

import com.dxc2.exception.DuplicatePaymentIdException;
import com.dxc2.model.Payment;

public interface PaymentService {
	public Payment addPayment(Payment payment) throws DuplicatePaymentIdException; 
	public List<Payment> AllPayments();
	
}
