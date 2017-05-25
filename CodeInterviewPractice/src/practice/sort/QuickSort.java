package practice.sort;

import java.util.Random;

public class QuickSort {
	public static void main(String args[]) {
		int[] input = new int[10];
		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			input[i] = rand.nextInt(1000);
			System.out.print(input[i] +",");
		}

		System.out.println();
		System.out.println(select(input, 1));
		System.out.println();
		quickSort(input);
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + ",");
		}
	}
	
	public static void quickSort(int[] input) {
		quickSort(input, 0, input.length -1);
	}
	
	public static void quickSort(int[] input, int lo, int hi) {
		if (lo >= hi) {
			return;
		}
		int pivotIdx = partition(input, lo, hi);
		quickSort(input, lo, pivotIdx);
		quickSort(input, pivotIdx+1, hi);
	}
	
	public static int select (int[] input, int k) {
		int lo = 0, hi = input.length-1;
		int lastPivot = partition(input, lo, hi);
		while (lastPivot != k) {
			if (lastPivot < k) {
				lo = lastPivot+1;
			} else {
				hi = lastPivot-1;
			}
			lastPivot = partition(input, lo, hi);
		}
		return input[lastPivot];
	}
	
	public static int partition (int[] input, int lo, int hi) {
		int pivot = input[lo];
		
		while (hi > lo) {
			while (input[lo] < pivot) lo++;
			while (input[hi] > pivot) hi--;
			swap(input, hi, lo);
		}
		return lo;
	}
	
	public static void swap(int[] input, int a, int b) {
		int tmp = input[a];
		input[a] = input[b];
		input[b] = tmp;
	}

}
