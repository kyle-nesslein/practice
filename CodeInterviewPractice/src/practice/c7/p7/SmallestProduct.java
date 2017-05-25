package practice.c7.p7;

import java.util.ArrayList;

public class SmallestProduct {
	public static void main(String args[]) {
		SmallestProduct s = new SmallestProduct();
		s.addFactor(3);
		s.addFactor(5);
		s.addFactor(7);
		
		System.out.println(s.getKth(8));
	}
	
	ArrayList<Integer> numbers;
	ArrayList<Integer> factors;
	public SmallestProduct() {
		numbers = new ArrayList<Integer>();
		factors = new ArrayList<Integer>();
	}
	
	public void addFactor(Integer f) {
		numbers.add(f);
		factors.add(f);
	}
	
	public int getKth(int k) {
		for (int i = factors.size(); i<k; i++) {
			nextNumber();
		}
		return numbers.get(numbers.size() -1);
	}

	public void nextNumber() {
		ArrayList<Integer> possibleNums = new ArrayList<Integer>();
		for (int factor : factors) {
			for (int num : numbers) {
				int n = factor * num;
				if (n> numbers.get(numbers.size()-1)) {
					possibleNums.add(n);
				}
			}
		}
		int min = possibleNums.get(0);
		for (int num : possibleNums) {
			if (num < min) {
				min = num;
			}
		}
		numbers.add(min);
	}
}