package com.thienloc.enums;

public enum OrderStatus {
	CONFIRM(0),
	CONFIRMED(1),
	TRANSPORT(2),
	SUCCESS(3),
	CANCEL(4);
	
	private int code;

	OrderStatus(int code) {
		this.setCode(code);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}
