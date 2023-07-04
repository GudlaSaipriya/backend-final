package com.dxc1.exception;

public class ProductExistsException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductExistsException() {
        super();
    }

    public ProductExistsException(String message) {
        super(message);
    }
}
