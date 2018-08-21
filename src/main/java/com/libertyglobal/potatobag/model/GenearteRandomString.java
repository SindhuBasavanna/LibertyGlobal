package com.libertyglobal.potatobag.model;

import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * To generate random string
 * 
 * @author sindhu
 */
@Component
public class GenearteRandomString {
	private static final String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	private static final int RANDOM_STRING_LENGTH = 10;
	private static Logger log = Logger.getLogger(GenearteRandomString.class);


	/**
	 * to generate random string
	 * 
	 * @return String
	 */
	public String generateRandomString() {
		log.info("Entering generateRandomString method:");
		StringBuffer randStr = new StringBuffer();
		for (int i = 0; i < RANDOM_STRING_LENGTH; i++) {
			int number = getRandomNumber();
			char ch = CHAR_LIST.charAt(number);
			randStr.append(ch);
		}
		log.info("End of generateRandomString method:");
		return randStr.toString();
	}

	/**
	 * To fetch random number
	 * 
	 * @return int
	 */
	private int getRandomNumber() {
		log.info("Entering getRandomNumber method:");
		int randomInt = 0;
		Random randomGenerator = new Random();
		randomInt = randomGenerator.nextInt(CHAR_LIST.length());
		if (randomInt - 1 == -1) {
			return randomInt;
		} else {
			return randomInt - 1;
		}
	}
}
