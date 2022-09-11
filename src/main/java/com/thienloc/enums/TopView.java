package com.thienloc.enums;

public enum TopView {
	DEFAULT(0),
	TOP_SALE(1),
	TOP_SEARCH(2),
	TOP_NEW(3);
	
	private int code;

	TopView(int code) {
		this.setCode(code);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}
