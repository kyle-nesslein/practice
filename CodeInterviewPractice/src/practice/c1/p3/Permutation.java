package practice.c1.p3;

import java.util.HashMap;

public class Permutation {
	public static void main(String args[]) {
		String input1 = "thisstring";
		String input2 = "stringthis";
		String input3 = "aaa";
		System.out.println(isPermutation(input1, input2));
		System.out.println(isPermutation(input1, input3));
	}
	
	public static boolean isPermutation(String in1, String in2) {
		if (in1.length() != in2.length()) {
			return false;
		}
		HashMap<Character, Integer> hash1 = new HashMap<Character, Integer>();
		HashMap<Character, Integer> hash2 = new HashMap<Character, Integer>();
		for (int i = 0; i < in1.length(); i++) {
			incrementHash(hash1, in1.charAt(i));
			incrementHash(hash2, in2.charAt(i));
		}
		
		return hash1.equals(hash2);
	}
	
	private static void incrementHash(HashMap<Character, Integer> hash, Character c) {
			if (hash.containsKey(c)) {
				int count = hash.get(c) + 1;
				hash.replace(c, count);
			} else {
				hash.put(c, 1);
			}
	}

}
