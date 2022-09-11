package com.thienloc.form;

import org.springframework.web.multipart.MultipartFile;

public class ImageProductForm {
	private Long productId;
	private Long imageId;
	private Long categoryId;
	private MultipartFile[] fileDatas;
	private MultipartFile thumbnail;
	
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
	public MultipartFile[] getFileDatas() {
		return fileDatas;
	}
	public void setFileDatas(MultipartFile[] fileDatas) {
		this.fileDatas = fileDatas;
	}
	public MultipartFile getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(MultipartFile thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	public ImageProductForm(Long productId, Long categoryId) {
		this.productId = productId;
		this.categoryId = categoryId;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	
}
