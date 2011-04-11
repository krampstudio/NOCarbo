package com.krampstudio.nopas.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class TokenGenerator {

	public static String generateToken(){
		String hash = null;
		
		Random r = new Random();
		Double d = new Double(r.nextGaussian());
		String clear = d.toString();
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			byte[] digest = md.digest( clear.getBytes() );
			hash = bytes2String(digest);
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return hash;
	}
	
	private static String bytes2String(byte[] bytes) {
	        StringBuilder string = new StringBuilder();
	        for (byte b: bytes) {
	                String hexString = Integer.toHexString(0x00FF & b);
	                string.append(hexString.length() == 1 ? "0" + hexString : hexString);
	        }
	        return string.toString();
	}

}
