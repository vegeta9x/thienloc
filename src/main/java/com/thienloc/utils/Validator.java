package com.thienloc.utils;

import java.util.List;

public class Validator {
	public static boolean checkEmpty(List<String> list, String str) {
		for (String item : list) {
			if(item.equalsIgnoreCase(str)) 
				return true;
		}
		return false;
	}
}
