package practice.fizzbuzz;

import java.util.Optional;

/*
 * Write a program that prints the numbers from 1 to 100. 
 * But for multiples of three print "Fizz" instead of the 
 * number and for the multiples of five print "Buzz". 
 * For numbers which are multiples of both three and five print "FizzBuzz".
 */
public class Fizzbuzz {
	public static void main(String args[]) {
		fizzbuzz2();
	}
	public static void fizzbuzz3(int number) {
		String result = Optional.of(number)
				.map(n -> (n % 3 == 0 ? "Fizz" : "") + (n % 5 == 0 ? "Buzz" : ""))
				.get();
		return result.isEmpty() ? Integer.toString(number) : result;
		
	}
	
	public static void fizzbuzz2() {
		for (int i =0; i<=100; i++) {
			if (i % 3 == 0 || i % 5 ==0 ) {
				if (i % 3 == 0) {
					System.out.println("Fizz");
				} else if (i % 5 == 0) {
					System.out.println("Buzz");
				}
			} else {
				System.out.println(i);
			}
		}
	}
	
	public static void fizzbuzz1() {
		for (int i = 0; i <= 100; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				System.out.println("FizzBuzz");
			} else if (i % 3 == 0) {
				System.out.println("Fizz");
			} else if (i % 5 == 0) {
				System.out.println("Buzz");
			} else {
				System.out.println(i);
			}
		}
	}
}
