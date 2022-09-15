package com.thienloc.model;

public class OrderDetails extends OrderDetailsKey {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column order_details.product_id
	 * @mbg.generated  Wed Sep 14 10:58:21 ICT 2022
	 */
	private Long productId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column order_details.quantity
	 * @mbg.generated  Wed Sep 14 10:58:21 ICT 2022
	 */
	private Integer quantity;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column order_details.price
	 * @mbg.generated  Wed Sep 14 10:58:21 ICT 2022
	 */
	private Long price;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column order_details.product_id
	 * @return  the value of order_details.product_id
	 * @mbg.generated  Wed Sep 14 10:58:21 ICT 2022
	 */
	public Long getProductId() {
		return productId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column order_details.product_id
	 * @param productId  the value for order_details.product_id
	 * @mbg.generated  Wed Sep 14 10:58:21 ICT 2022
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column order_details.quantity
	 * @return  the value of order_details.quantity
	 * @mbg.generated  Wed Sep 14 10:58:21 ICT 2022
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column order_details.quantity
	 * @param quantity  the value for order_details.quantity
	 * @mbg.generated  Wed Sep 14 10:58:21 ICT 2022
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column order_details.price
	 * @return  the value of order_details.price
	 * @mbg.generated  Wed Sep 14 10:58:21 ICT 2022
	 */
	public Long getPrice() {
		return price;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column order_details.price
	 * @param price  the value for order_details.price
	 * @mbg.generated  Wed Sep 14 10:58:21 ICT 2022
	 */
	public void setPrice(Long price) {
		this.price = price;
	}
}