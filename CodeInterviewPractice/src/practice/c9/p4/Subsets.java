package practice.c9.p4;

import java.util.ArrayList;
import java.util.HashSet;

public class Subsets {
	public static void main(String args[]) {
		HashSet<Integer> set  = new HashSet<Integer>();
		final int SIZE = 4;
		for (int i = 0; i < SIZE; i++) {
			set.add(i);
		}
		
		HashSet<HashSet<Integer>> r = getIterativeSubsets(set);
		for(HashSet<Integer> h : r) {
			System.out.print("{");
			for (Integer i : h) {
				System.out.print(i + ",");
			}
			System.out.print("},");
		}
	}
	
	public static HashSet<HashSet<Integer>> getSubsets(HashSet<Integer> input) {
		HashSet<HashSet<Integer>> result = new HashSet<HashSet<Integer>>();
		return getSubsets(input, result);
	}
	
	public static HashSet<HashSet<Integer>> getSubsets(HashSet<Integer> input, HashSet<HashSet<Integer>> results) {
		for (Integer i : input) {
			HashSet<Integer> h = (HashSet<Integer>) input.clone();
			h.remove(i);
			if (!results.contains(h)) {
				results.add(h);
				getSubsets(h, results);
			}
		}
		return results;
	}
	
	public static HashSet<HashSet<Integer>> getIterativeSubsets(HashSet<Integer> input) {
		HashSet<HashSet<Integer>> result = new HashSet<HashSet<Integer>>();
		Object[] array = input.toArray();
		
		for (long i = 0; i < Math.pow(2, input.size()); i++) {
			HashSet<Integer> h = new HashSet<Integer>();
			for (int j = 0; j<input.size(); j++) {
				if (((i >> j) & 0x01) == 1) {
					h.add((Integer) array[j]);
				}
			}
			result.add(h);
		}
		return result;
	}

}
