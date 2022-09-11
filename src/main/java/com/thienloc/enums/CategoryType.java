package com.thienloc.enums;

public enum CategoryType {
	MAIN(1),
	SUB(2);
	
	private int code;

	CategoryType(int code) {
		this.setCode(code);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}
