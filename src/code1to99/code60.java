package code1to99;

import java.util.ArrayList;
import java.util.List;

public class code60 {

	/**
	 * @param n 生成的排列数 k
	 */
	public static String getPermutation(int n, int k) {
		int sum = 1;
		int avg = 0;
		int[] array = new int[n];
		for (int i = 1; i <= n; i++) {
			sum *= i;
			array[i - 1] = i;
		}
		avg = sum / n;
		int position = 0;
		int num = 0;
		if (k > avg) {
			position = k % avg;
			num = (k / avg);
		} else {
			position = k;
		}
		
		return "";
	}

	public static void arrayList(int[] array, int num, int position) {
		
	}

	public static int[] SwitchArrayElement(int[] nums, int x, int y) {
		int[] tmpnums = nums;
		int tmp = tmpnums[x];
		tmpnums[x] = tmpnums[y];
		tmpnums[y] = tmp;
		return tmpnums;
	}
}
