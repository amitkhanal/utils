package com.acme.algorithm;

import java.util.HashMap;

public class StringUtils {

	public static void main(String[] args) {
		System.out.println(containsUniqueCharacters("abcdefgh"));
		System.out.println(containsUniqueCharacters("abcd321yua"));
		System.out.println(isPalindromePermutation("abbabb"));
		System.out.println(getCompressedText("aaabbbbbcddeqqqqqqqqq"));
	}

	public static boolean containsUniqueCharacters(String text) {
		
		if(text == null || text.length() > 128) {  // assuming this is ascii text that has at most 128 characters
			return false;
		}
		boolean[] chars = new boolean[128];
		
		for(int i=0; i<text.length(); i++) {
			int val = text.charAt(i);
			if(chars[val]) {
				return false;
			}
			chars[val]=true;
		}
		return true;
	}
	
	public static boolean isPalindromePermutation(String text) {
		if(text == null || text.length() ==0) {
			return false;
		}
		int[] charArray = new int[128]; 
		String lowerCaseText = text.toLowerCase();
		
		for(int i=0; i<lowerCaseText.length(); i++) {
			int character = lowerCaseText.charAt(i);
			charArray[character]++;
		}
		
		boolean foundOdd = false;
		for(int i=0; i<charArray.length; i++) {
			int count = charArray[i];
			if(count % 2 == 1) {
				if(foundOdd) {
					return false;
				}
				foundOdd = true;
			}
		}
		return true;
	}
	
	public boolean isOneEditAway(String text) {
		return false;
	}
	
	public static String getCompressedText(String text) {
		if(text == null) {
			return null;
		}
		
		StringBuilder compressedText = new StringBuilder();
		Character character = null;
		int count=0;
		for(int i=0; i<text.length(); i++){
			if(character == null) {
				character=text.charAt(i);
				count++;
			}else if(character!=text.charAt(i)) {
				compressedText.append(character).append(""+count);
				character = text.charAt(i);
				count = 1;
			}else {
				count++;
			}
		}
		compressedText.append(character).append(""+count);
		return compressedText.toString();
	}
	
}
