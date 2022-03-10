

public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		throw new RuntimeException("method not implemented");
	}
	
	/**
	 * This method adjusts codes for characters if they're out
	 * of LOWER_BOUND or UPPER_BOUND characters
	 * @param charToWrap character to adjust code for
	 * @return charcater that is now within the allowed bounds
	 */
	private static char adjustASCIICode(char charToWrap) {
		char wrappedChar = 0;
		if (charToWrap < LOWER_BOUND) {
			while (charToWrap < LOWER_BOUND) {
				wrappedChar = (char) (charToWrap + RANGE);
			}
		}
		else {
			while (charToWrap > UPPER_BOUND) {
				wrappedChar = (char) (charToWrap - RANGE);
			}
		}
		return wrappedChar;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		StringBuilder sb = new StringBuilder();
		char CharAtPosition;
		char CharAtPositionEncrypted;
		int ASCIICodeWrapped = 0;
		for (int i = 0; i < plainText.length(); i++) {
			CharAtPosition = plainText.charAt(i);
			if (CharAtPosition >= LOWER_BOUND && CharAtPosition <= UPPER_BOUND) {
				CharAtPositionEncrypted = (char) (CharAtPosition + key);
				sb.append(CharAtPositionEncrypted);
			}
			else {
				 ASCIICodeWrapped = adjustASCIICode(CharAtPosition);
				 sb.append(ASCIICodeWrapped);
			}
		}
		String encryptedString = sb.toString();
		return encryptedString;
	}
	
	/**
	 * Adjusts key String until it matches the length of plainText
	 * @param String that is used to encrypt plainText
	 * @param String to encrypt
	 * @return key string whose length matches the plainText
	 */
	
     public static String adjustKeyString(String bellasoStr, String plainText) {
    	 String newKeyString = "";
    	 while (bellasoStr.length() < plainText.length()) { 
    		 if (newKeyString.length() + bellasoStr.length() < plainText.length())
    			 newKeyString += bellasoStr; //Continue adding whole String if it fits
    		 else 
    			 //If you still need to adjust key String but whole does not fit, get a substring.
    			 newKeyString += bellasoStr.substring(0, plainText.length() - newKeyString.length()); 
    	 }
    	 return newKeyString;
     }

	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		String keyString = adjustKeyString(bellasoStr, plainText);
		char charAtPositionOfPlainText;
		char charAtPositionOfBellasoStr;
		char encodedChar;
		int ASCIICodeWrapped = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < plainText.length(); i++) {
			charAtPositionOfPlainText = plainText.charAt(i);
			charAtPositionOfBellasoStr = keyString.charAt(i); //FIXME might not work
			encodedChar = (char)(charAtPositionOfPlainText + charAtPositionOfBellasoStr);
			if (encodedChar >= LOWER_BOUND && encodedChar <= UPPER_BOUND) {
				sb.append(encodedChar);
			} else {
			  ASCIICodeWrapped = adjustASCIICode(encodedChar); //FIXME might not work
			  sb.append(ASCIICodeWrapped);
			}
		}
		String encryptedString = sb.toString();
		return encryptedString;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		StringBuilder sb = new StringBuilder();
		char CharAtPosition;
		char CharAtPositionEncrypted;
		int ASCIICodeWrapped = 0;
		for (int i = 0; i < encryptedText.length(); i++) {
			CharAtPosition = encryptedText.charAt(i);
			if (CharAtPosition >= LOWER_BOUND && CharAtPosition <= UPPER_BOUND) {
				CharAtPositionEncrypted = (char) (CharAtPosition - key);
				sb.append(CharAtPositionEncrypted);
			}
			else {
				 ASCIICodeWrapped = adjustASCIICode(CharAtPosition);
				 sb.append(ASCIICodeWrapped);
			}
		}
		String encryptedString = sb.toString();
		return encryptedString;
		
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		throw new RuntimeException("method not implemented");
	}
}
