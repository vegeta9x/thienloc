package com.thienloc.form;

import java.util.List;

import com.thienloc.model.Category;

public class HomeForm {
	private Category categoryMain;
	private List<Category> categorySubList;
	private List<ProductForm> productList;
	
	
	public Category getCategoryMain() {
		return categoryMain;
	}
	public void setCategoryMain(Category categoryMain) {
		this.categoryMain = categoryMain;
	}
	public List<Category> getCategorySubList() {
		return categorySubList;
	}
	public void setCategorySubList(List<Category> categorySubList) {
		this.categorySubList = categorySubList;
	}
	public List<ProductForm> getProductList() {
		return productList;
	}
	public void setProductList(List<ProductForm> productList) {
		this.productList = productList;
	}
	
}
