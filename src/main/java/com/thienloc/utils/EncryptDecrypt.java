package com.thienloc.utils;

import java.util.Base64;

public class EncryptDecrypt {
	
	public static String encrypt(String strToEncrypt) {
	      return Base64.getEncoder().withoutPadding().encodeToString(strToEncrypt.getBytes());
	      
	}
	
	public static String decrypt(String strToDecrypt) {
		byte[] decodedBytes = Base64.getDecoder().decode(strToDecrypt);
        String decodedString = new String(decodedBytes);
        
        return decodedString;
	}
}
