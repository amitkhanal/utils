package com.acme.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CollectionUtils {

	public static void main(String[] args) {
		int[] a = new int[15];
		int index = 0;
		for(int i=20;i<27; i++) {
			a[index++] = i;
		}
		int[] b = {10,11,12,21,22};
		
		//merge(a,b,7,5);
		//mergeSortedArrays(a,b,7,5);
		//System.out.println(Arrays.toString(a));
		sortAnagrams();
		
		int[] array = new int[200];
		for(int i=0; i<100; i++) {
			array[i] = i;
		}
		for(int i=100; i<200; i++) {
			array[i] = -1;
		}
		
		//System.out.println(" Found index -> " +findItemInSortedCollection(array, 71));
		System.out.println(" Found index -> " + getIndexFromSortedCollection(array, 70));
	}
	
	public static int findItemInSortedCollection(int[] array, int value) {
		if(array==null || array.length==0) {
			return 0;
		}
		
		int index = 1;
		while(array[index]!=-1 && array[index] <= value) {
			index *= 2;
		}
		System.out.println("Searching between " + index/2 + " and "+ index);
		return search(array, value, index/2, index);
		
	}
	
	public static int search(int[] array, int value, int low, int high) {
		int mid = 0;
		while(low <= high) {
			mid = (low + high)/2;
			System.out.println(" Mid - "+ mid + " low - "+ low + " high - "+ high + " value at mid - " + array[mid]);
			if(array[mid] == -1 || array[mid] > value) {
				high = mid-1;
			}else if(array[mid] < value) {
				low = mid+1;
			}else {
				return mid;
			}
		}
		return -1;
	}
	
	public static void mergeSortedArrays(int[] a, int[] b, int lastA, int lastB) {
		if(a == null || a.length == 0 || b==null || b.length == 0) {
			return;
		}
		
		int indexA = lastA-1;
		int indexB = lastB-1;
		int indexMerged = lastA + lastB -1;
		
		while(indexB >= 0) {
			if(indexA >= 0 && a[indexA] > b[indexB]) {
				a[indexMerged] = a[indexA];
				indexA--;
			}else {
				a[indexMerged] = b[indexB];
				indexB--;
			}
			indexMerged--;
		}
		
	}
	
	static void merge(int[] a, int[] b, int lastA, int lastB) {
		int indexA = lastA - 1; /* Index of last element in array a */ 
		int indexB = lastB - 1; /* Index of last element in array b */ 
		int indexMerged = lastB + lastA - 1; /* end of merged array */

		/*
		 * Merge a and b, starting from the last element in each /1
		 * 
		 */
		while (indexB >= 0) {
			/* end of a is > than end of b */
			if (indexA >= 0 && a[indexA] > b[indexB]) {
				a[indexMerged] = a[indexA]; // copy element
				indexA--;
			} else {
				a[indexMerged] = b[indexB]; // copy element
				indexB--;
			}
			indexMerged--; // move indices

		}
	}
	
	static void sortAnagrams() {
		String[] a = {"abc", "bac", "cab", "cad", "adc", "eef", "bac", "fee", "xyz"};
		
		HashMap<String, List<String>> anagramMap = new HashMap<>();
		
		for(int i=0; i<a.length; i++) {
			if(a[i]==null) {
				continue;
			}
			String currentText = a[i];
			boolean anagramFound = false;
			for(int j=i+1; j<a.length; j++) {
				if(a[j]==null){
					continue;
				}
				boolean isAnagram = AnagramTester.isAnagram(currentText, a[j]);
				if(isAnagram) {
					anagramFound = true;
					if(anagramMap.containsKey(currentText)) {
						anagramMap.get(currentText).add(a[j]);
					}else {
						List<String> anagramList = new ArrayList<>();
						anagramList.add(currentText);
						anagramList.add(a[j]);
						anagramMap.put(currentText, anagramList);
					}
					a[j]=null;
				}
			}
			if(!anagramFound) {
					List<String> anagramList = new ArrayList<>();
					anagramList.add(currentText);
					anagramMap.put(currentText, anagramList);
			}
			
		}
		List<String> anagrams = new ArrayList<String>();
		for(List<String> anagramList: anagramMap.values()) {
			anagrams.addAll(anagramList);
		}
		System.out.println(anagrams);
	}
	
	
	public static int getIndexFromSortedCollection(int[] array, int value) {
		if(array == null || array.length == 0) {
			return 0;
		}
		int index = 1;
		
		while(array[index] != -1 && array[index] < value) {
			index *= 2;
		}
		System.out.println("Searching between " + index/2 + " and "+ index);
		return performBinarySearch(array, value, index/2, index);
		
		
	}

	private static int performBinarySearch(int[] array, int value, int low, int high) {
		int mid = 0;
		
		while(low <= high) {
			mid = (low+high)/2;
			System.out.println(" Mid - "+ mid + " low - "+ low + " high - "+ high + " value at mid - " + array[mid]);
			if(array[mid] == -1 || array[mid] > value) {
				high = mid - 1;
			}else if(array[mid] < value) {
				low = mid + 1;
			}else {
				return mid;
			}
		}
		return -1;
	}
}