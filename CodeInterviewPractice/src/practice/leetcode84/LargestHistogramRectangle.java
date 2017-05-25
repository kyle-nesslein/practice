package practice.leetcode84;

public class LargestHistogramRectangle {
	public class Solution {
	    public int largestRectangleArea(int[] heights) {
	        int largest = 0;
	        for (int size = heights.length; size > 0; size--) {
	            int lo = 0;
	            int hi = size-1;
	            while (hi < heights.length) {
	                int min = getMin(heights, lo, hi);
	                int rect = min * size;
	                if (rect > largest) {
	                    largest 0= rect;
	                }
	                hi++;
	                lo++;
	            }
	        }
	        return largest;
	    }
	    
	    private int getMin(int[] heights, int lo, int hi) {
	        int min = heights[lo];
	        for (int i = lo; i <= hi; i++) {
	            if (heights[i] < min) {
	                min = heights[i];
	            }
	        }
	        return min;
	    }
	}
}
