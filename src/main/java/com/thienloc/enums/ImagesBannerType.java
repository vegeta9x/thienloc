package com.thienloc.enums;

import java.util.ArrayList;
import java.util.List;

public enum ImagesBannerType {
	BANNER(1),
	BANNER_SUB_1(2),
	BANNER_SUB_2(3),
	AVATAR(5);
	
	private int code;

	ImagesBannerType(int code) {
		this.setCode(code);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	public List<Integer> test() {
		List<Integer> result = new ArrayList<>();
		
		for (ImagesBannerType item : ImagesBannerType.values()) {
			result.add(item.getCode());
		}
		
		return result;
	}

}
