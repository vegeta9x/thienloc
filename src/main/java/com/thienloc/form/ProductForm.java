package com.thienloc.form;

import java.util.Date;

public class ProductForm {
	private Long productId;
	private String productName;
	private String productCode;
	private Long price;
	private Integer promotionFlag;
	private Long promotionPrice;
	private Integer display;
	private Integer quantity;
	private Date updatedDate;
	private String categoryName;
	private String categoryCode;
	private Long categoryId;
	private String categoryParentName;
	private String categoryParentCode;
	private Long categoryParentId;
	private String imageName;
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getPromotionPrice() {
		return promotionPrice;
	}
	public void setPromotionPrice(Long promotionPrice) {
		this.promotionPrice = promotionPrice;
	}
	public Integer getPromotionFlag() {
		return promotionFlag;
	}
	public void setPromotionFlag(Integer promotionFlag) {
		this.promotionFlag = promotionFlag;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryParentName() {
		return categoryParentName;
	}
	public void setCategoryParentName(String categoryParentName) {
		this.categoryParentName = categoryParentName;
	}
	public String getCategoryParentCode() {
		return categoryParentCode;
	}
	public void setCategoryParentCode(String categoryParentCode) {
		this.categoryParentCode = categoryParentCode;
	}
	public Long getCategoryParentId() {
		return categoryParentId;
	}
	public void setCategoryParentId(Long categoryParentId) {
		this.categoryParentId = categoryParentId;
	}
	public Integer getDisplay() {
		return display;
	}
	public void setDisplay(Integer display) {
		this.display = display;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
}
