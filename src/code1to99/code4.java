package code1to99;

import java.util.Arrays;

public class code4 {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int length1 = nums1.length;
		int length2 = nums2.length;
		int length = length1 + length2;
		int[] array = new int[length];
		int i = 0;
		for(int num : nums1) {
			array[i] = num;
			i++;
		}
		for(int num : nums2) {
			array[i] = num;
			i++;
		}
		Arrays.sort(array);
		
		if(length%2 == 0) {
			int a = length/2;
			return (Double.parseDouble(String.valueOf(array[a])) + Double.parseDouble(String.valueOf(array[a-1])))/2;
		}else {
			int a = (length-1)/2;
			return array[a];
		}
	}
}
