package com.thienloc.enums;

public enum Flag {
	ON(1),
	OFF(0);
	
	private int code;

	Flag(int code) {
		this.setCode(code);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}
