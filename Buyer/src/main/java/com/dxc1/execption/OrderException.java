package com.dxc1.execption;

public class OrderException extends Exception{

	public OrderException() {
        super();
    }
	
	public OrderException(String message) {
        super(message);
    }
}