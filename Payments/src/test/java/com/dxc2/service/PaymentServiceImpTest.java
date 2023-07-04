package com.dxc2.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.dxc2.exception.DuplicatePaymentIdException;
import com.dxc2.model.Payment;
import com.dxc2.repository.PaymentRepository;

@SpringBootTest
public class PaymentServiceImpTest {
	
	@MockBean
	private PaymentRepository repo;

	@Autowired
	private PaymentService service;

	@Test
    public void createPaymentTest() throws DuplicatePaymentIdException {
		Payment payment =new Payment(1,"toy","9-8-23",2000.00,"cash");
		when(repo.save(payment)).thenReturn(payment);
		assertEquals(payment,service.addPayment(payment));
	}
	
	@Test
	public void getAllPayment() {
		when(repo.findAll()).thenReturn(Stream.of
				(new Payment(2,"bed","23-08-2023",1882.00,"card"),new Payment(3,"johnsonkit","03-08-2023",1000.00,"card")).collect(Collectors.toList()));
		 assertEquals(2,service.AllPayments().size());
	}

}
