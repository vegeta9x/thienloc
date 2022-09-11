package com.thienloc.form;

import java.util.List;

public class CheckoutForm {
	private Long totalPrice;
	private Integer totalProduct;
	private String custommerName;
	private String customerAddress;
	private String customerEmail;
	private String customerPhone;
	private String note;
	private Integer methodPay;
	private List<OrderDetail> orderDetails;
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
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
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
	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
}
