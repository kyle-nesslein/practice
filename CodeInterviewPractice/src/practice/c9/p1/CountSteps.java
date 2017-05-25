package practice.c9.p1;

public class CountSteps {
	public static void main(String args[]) {
		System.out.println(countSteps(36));
		
	}
	
	public static int countSteps(int total) {
		return countSteps(total, new int[total]);
	}
	
	public static int countSteps(int total, int[] cache) {
		if (cache[total] != 0) {
			return cache[total];
		}
		return countSteps(total-1) + countSteps(total-2) + countSteps(total-3);
	}
}
