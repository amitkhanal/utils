package com.acme.algorithm;

public class PalindromeTester {

	public static boolean isPalindrome(String text1) {
		if( text1== null || text1.length()==0) {
			return false;
		}
		//String cleanText = text1.replaceAll("\\s+", "").toLowerCase();
		String cleanText = text1.replaceAll("[^a-zA-Z\\d(\\s+):]", "").toLowerCase();
		
		int forward = 0;
		int backward = cleanText.length()-1;
		
		while(backward > forward) {
			if(cleanText.charAt(forward) != cleanText.charAt(backward)) {
				return false;
			}
			forward++;
			backward--;
		}
		return true;
	}
	
	/*public static String getLongestPalindrome(String text) {
		if(text==null) {
			return null;
		}
		String cleanText = text.replaceAll("\\s+", text);
		int index = 0;
		while(index < cleanText.length()) {
			String subText = cleanText.substring(index, cleanText.length());
			System.out.println("Checking -> "+ subText);
			if(isPalindrome(subText)) {
				return subText;
			}
			index++;
		}
		return null;
		
	}*/
	
	private static String longestPalindromeString(String string) {

		String p = "";
		for (int i = 0; i < string.length(); i++) {
			String str = "";
			for (int j = i; j < string.length(); j++) {
				str += string.charAt(j);
				String revStr = new StringBuilder(str).reverse().toString();
				if (string.contains(revStr) && p.length() < revStr.length()) {
					p = revStr;
				}
				if (p.length() == string.length()) {
					break;
				}
			}
		}
		return p;
	}
	
	private static String getLongestPalindrome(String text) {
		String output = "";
		
		int index = 0;
		
		while(index < text.length()) {
			
			for (int j = index; j < text.length(); j++) {
				String textToCheck = text.substring(index, j+1);
				StringBuilder textBuilder = new StringBuilder(textToCheck).reverse();
				if(text.contains(textBuilder.toString()) && textBuilder.length() > output.length()){
					output = textToCheck;
				}
			}
			index++;
		}
		
		return output;
	}
	
	public static void main(String[] args) {
		/*System.out.println("Kayak -> "+ isPalindrome("kayak"));
		System.out.println("civic -> "+ isPalindrome("civic"));
		System.out.println("nurses -> "+ isPalindrome("nurses"));
		System.out.println("house -> "+ isPalindrome("house"));
		System.out.println("madam -> "+ isPalindrome("madam"));*/
		//System.out.println("Doc, note: I dissent. A fast never prevents a fatness. I diet on cod." + 
		//		isPalindrome("Doc, note: I dissent. A fast never prevents a fatness. I diet on cod."));
		System.out.println("Longest palindrome -> " + getLongestPalindrome("afd1122asdabccivicab12333321c"));
	}
}
