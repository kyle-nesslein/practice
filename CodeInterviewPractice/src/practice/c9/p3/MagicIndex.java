package practice.c9.p3;

public class MagicIndex {
	public static void main(String args[]) {
		int[] input = new int[]{-4,-2,1,2,3,5,10};
		System.out.println(getMagicIndex(input));
		
	}
	
	public static Integer getMagicIndex(int[] input) {
		int lo=0;
		int hi = input.length -1;
		while(lo<=hi) {
			int mid = (lo+hi)/2;
			if (input[mid] == mid) {
				return mid;
			} else if (input[mid] < mid) {
				lo = mid +1;
			} else {
				hi = mid -1;
			}
		}
		return null;
	}

	public static Integer binarySearch(int[] input, int search) {
		int lo=0;
		int hi = input.length-1;
		while (lo <=hi) {
			int mid = (lo+hi)/2;
			if (input[mid]==search) {
				return mid;
			} else if (input[mid] < search) {
				lo = mid + 1;
			} else {
				hi = mid -1;
			}
		}
		return null;
	}
}
