package com.acme.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

	public static void main(String[] args) {
		getFibonacciNumbers(20);
		System.out.println(getFibonacciTotal(10));
		System.out.println(fib(10));
	}

	private static void getFibonacciNumbers(int size) {
		List<Integer> numbers = new ArrayList<Integer>(size);

		for (int i = 0; i < size; i++) {
			System.out.print(i+" ,");
			int number = i;
			if(i==0 || i==1){
				numbers.add(i);
				continue;
			}
			number = numbers.get(i-1) + numbers.get(i-2);
			numbers.add(number);
		}
		System.out.println("\n"+numbers);
	}

	private static int getFibonacciTotal(int size) {
		
		int firstNumber = 0;
		int secondNumber = 1;
		int total = 0;
		for(int i=2; i<size; i++) {
			total = firstNumber + secondNumber;			
			firstNumber = secondNumber;
			secondNumber = total;
		}
		return total;
	}
	
	 static int fib(int n)
	    {
	    if (n <= 1)
	       return n;
	    return fib(n-1) + fib(n-2);
	    }
}
