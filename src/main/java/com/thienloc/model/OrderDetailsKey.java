package com.thienloc.model;

public class OrderDetailsKey {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column order_details.order_id
	 * @mbg.generated  Wed Sep 14 10:58:21 ICT 2022
	 */
	private String orderId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column order_details.order_detail_id
	 * @mbg.generated  Wed Sep 14 10:58:21 ICT 2022
	 */
	private Long orderDetailId;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column order_details.order_id
	 * @return  the value of order_details.order_id
	 * @mbg.generated  Wed Sep 14 10:58:21 ICT 2022
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column order_details.order_id
	 * @param orderId  the value for order_details.order_id
	 * @mbg.generated  Wed Sep 14 10:58:21 ICT 2022
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column order_details.order_detail_id
	 * @return  the value of order_details.order_detail_id
	 * @mbg.generated  Wed Sep 14 10:58:21 ICT 2022
	 */
	public Long getOrderDetailId() {
		return orderDetailId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column order_details.order_detail_id
	 * @param orderDetailId  the value for order_details.order_detail_id
	 * @mbg.generated  Wed Sep 14 10:58:21 ICT 2022
	 */
	public void setOrderDetailId(Long orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
}