package io.dpm.dropmenote.ws.services.helpers;

import java.util.Random;

public class NameGenerationHelper {
	
	private static final String[] imageNames = new String[] { 
			"alligator", "bear", "beaver", "butterfly",
			"camel", "cat", "crab", "deer", "dolphin",
			"elephant", "frog", "giraffe", "gorilla", "horse", "jaguar",
			"kangaroo", "leopard", "llama", "mouse", "panda", "rabbit", 
			"snail", "spider", "turtle", "whale", "wolf"
	};
	
	/**
	 * get random animal name
	 * @return
	 */
	public static String getRandomName() {
		return imageNames[new Random().nextInt(imageNames.length)];
	}
	
	/**
	 * get random animal name with number postfix
	 * @param digits
	 * @return
	 */
	public static String getRandomName(int digits) {
		final String numericString = "0123456789";
		StringBuilder sb = new StringBuilder(getRandomName());
		for (int i = 0; i < digits; i++) {
			int index = (int)(numericString.length() * Math.random()); 
			sb.append(numericString.charAt(index)); 
		}
		return sb.toString();
	}
}
