package com.thienloc.form;

import java.util.List;

public class CheckoutForm {
	private Long totalPrice;
	private Integer totalProduct;
	private String custommerName;
	private String customerAddress_1;
	private String customerAddress_2;
	private String customerEmail;
	private String customerPhone;
	private String note;
	private Integer methodPay;
	//private List<OrderDetail> orderDetails;
	
	public Long getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Integer getTotalProduct() {
		return totalProduct;
	}
	public void setTotalProduct(Integer totalProduct) {
		this.totalProduct = totalProduct;
	}
	public String getCustommerName() {
		return custommerName;
	}
	public void setCustommerName(String custommerName) {
		this.custommerName = custommerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Integer getMethodPay() {
		return methodPay;
	}
	public void setMethodPay(Integer methodPay) {
		this.methodPay = methodPay;
	}
	public String getCustomerAddress_1() {
		return customerAddress_1;
	}
	public void setCustomerAddress_1(String customerAddress_1) {
		this.customerAddress_1 = customerAddress_1;
	}
	public String getCustomerAddress_2() {
		return customerAddress_2;
	}
	public void setCustomerAddress_2(String customerAddress_2) {
		this.customerAddress_2 = customerAddress_2;
	}
	/*
	 * public List<OrderDetail> getOrderDetails() { return orderDetails; } public
	 * void setOrderDetails(List<OrderDetail> orderDetails) { this.orderDetails =
	 * orderDetails; }
	 */
	
}
