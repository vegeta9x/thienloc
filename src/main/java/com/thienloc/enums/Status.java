package com.thienloc.enums;

public enum Status {
	DEFAULT(0),
	PRODUCT_NAME(1),
	CATEGORY_NAME(2);
	
	private int code;

	Status(int code) {
		this.setCode(code);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}
