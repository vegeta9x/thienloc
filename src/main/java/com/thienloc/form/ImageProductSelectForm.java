package com.thienloc.form;

public class ImageProductSelectForm {
	private Long productId;
	private Long imageId;
	private String name;
	private String contentType;
	private Long size;
	private Long categorySubId;
	private Long categoryMainId;
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getImageId() {
		return imageId;
	}
	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	public Long getCategorySubId() {
		return categorySubId;
	}
	public void setCategorySubId(Long categorySubId) {
		this.categorySubId = categorySubId;
	}
	public Long getCategoryMainId() {
		return categoryMainId;
	}
	public void setCategoryMainId(Long categoryMainId) {
		this.categoryMainId = categoryMainId;
	}
	
}
