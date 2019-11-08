package code1to99;

import java.util.ArrayList;
import java.util.List;

public class code46 {

	public static void main(String[] args) {
		List<List<Integer>> list = permute(new int[] { 1, 2, 3 });
		System.out.println(list);
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		dfs(lists, nums);
		return lists;
	}

	public static void dfs(List<List<Integer>> lists, int[] nums) {
		List<Integer> bs = new ArrayList<Integer>();
		bs.add(addArray(lists, nums));
		for (int i = 1; i < nums.length; i++) {
			int[] tmpnums = SwitchArrayElement(nums, i-1, i);
			int j = addArray(lists, tmpnums);
			if (j != 0) {
				dfs(lists, tmpnums);
			}
		}
	}

	public static int[] SwitchArrayElement(int[] nums, int x, int y) {
		int[] tmpnums = nums;
		int tmp = tmpnums[x];
		tmpnums[x] = tmpnums[y];
		tmpnums[y] = tmp;
		return tmpnums;
	}

	public static int addArray(List<List<Integer>> lists, int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
		for (Integer num : nums) {
			list.add(num);
		}
		if (lists.contains(list)) {
			return 0;
		} else {
			lists.add(list);
		}
		return 1;
	}

}
