package com.acme.algorithm;

import java.util.Arrays;

public class AnagramTester {

	public static boolean isAnagram(String text1, String text2) {
		if(text1==null || text2==null) {
			return false;
		}
		String cleanText1=text1.replaceAll("\\s+", "").toLowerCase();
		String cleanText2=text2.replaceAll("\\s+", "").toLowerCase();
		
		if(cleanText1.length()!=cleanText2.length()) {
			return false;
		}
		
		char[] text1Chars = cleanText1.toCharArray();
		char[] text2Chars=cleanText2.toCharArray();
		
		Arrays.sort(text1Chars);
		Arrays.sort(text2Chars);
		
		return Arrays.equals(text1Chars, text2Chars);
		
	}
	
	public static void main(String[] args) {
		System.out.println(isAnagram("sad", "das"));
		System.out.println(isAnagram("SiLeNt CAT ", "LisTen AcT"));
		System.out.println(isAnagram("civic", "viicc"));
		
	}
}
