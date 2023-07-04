package com.dxc1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="buyerorder")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int orderid;
	int productid;
	String buyername;
	long buyermobile;
	String buyeraddress;
	String paymentmode;
	
	public Order() {
		super();
	}
	public Order(int orderid, int productid, String buyername, long buyermobile, String buyeraddress,
			String paymentmode) {
		super();
		this.orderid = orderid;
		this.productid = productid;
		this.buyername = buyername;
		this.buyermobile = buyermobile;
		this.buyeraddress = buyeraddress;
		this.paymentmode = paymentmode;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getBuyername() {
		return buyername;
	}
	public void setBuyername(String buyername) {
		this.buyername = buyername;
	}
	public long getBuyermobile() {
		return buyermobile;
	}
	public void setBuyermobile(long buyermobile) {
		this.buyermobile = buyermobile;
	}
	public String getBuyeraddress() {
		return buyeraddress;
	}
	public void setBuyeraddress(String buyeraddress) {
		this.buyeraddress = buyeraddress;
	}
	public String getPaymentmode() {
		return paymentmode;
	}
	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}
}

