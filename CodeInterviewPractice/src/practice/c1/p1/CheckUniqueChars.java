package practice.c1.p1;

import java.util.HashSet;

// Assuming UTF-8, and checking for all characters

public class CheckUniqueChars {
	static public void main(String args[]) {
		String input = "uuniqe";
		System.out.println(checkStringLinear(input.toString()));
		System.out.println(checkStringSquared(input.toString()));
		System.out.println(checkStringHash(input.toString()));
		System.out.println(hasUniqueCharsBitVector(input.toString()));
	}
	static Boolean hasUniqueCharsBitVector(String input) {
		int vector = 0;
		for (int i = 0; i < input.length(); i++) {
			char val = (char)(input.charAt(i) - 'a');
			if (( vector & (1 << val)) > 0) {
				return false;
			}
			vector |= (1 << val);
		}
		return true;
	}

	
	static Boolean checkStringLinear(String input) {
		if (input.length() > 256) {
			return false;
		}
		boolean[] once = new boolean[256];
		for (int i = 0; i < input.length(); i++) {
			if (once[(int) input.charAt(i)] == true) {
				return false;
			} else {
				once[(int) input.charAt(i)] = true;
			}
		}
		return true;
	}
	
	static Boolean checkStringSquared(String input) {
		if (input.length() > 256) {
			return false;
		}
		for (int i = 0; i < input.length(); i++) {
			for (int j = i+1; j < input.length(); j++) {
				if (input.charAt(i) == input.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}
	
	static Boolean checkStringHash(String input) {
		HashSet<Character> set = new HashSet<Character>();
		for (int i = 0; i < input.length(); i++) {
			Character currentChar = new Character(input.charAt(i));
			if (set.contains(currentChar)) {
				return false;
			} else {
				set.add(currentChar);
			}
		}
		return true;
	}
}
