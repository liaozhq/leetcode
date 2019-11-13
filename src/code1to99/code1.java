package code1to99;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 
 * 示例:
 * 
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 
 * 因为 nums[0] + nums[1] = 2 + 7 = 9 所以返回 [0, 1]
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code1 {

	public static void main(String[] args) {
		int[] tags = new int[5];
		tags[0] = 1;
		tags[1] = 2;
		tags[2] = 3;
		tags[3] = 4;
		tags[4] = 5;
		System.out.println(Arrays.copyOfRange(tags, 0, tags.length).length);
//		for (int key : twoSum(new int[] { 2, 7, 11, 15 }, 9)) {
//			System.out.println(key);
//		}
	}

	public static int[] twoSum(int[] nums, int target) {
		int length = nums.length;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < length; i++) {
			if (nums[i] < target) {
				map.put(nums[i], i);
			}
		}

		int[] tags = new int[map.values().size()];
		int i = 0;
		for (int key : map.keySet()) {
			tags[i] = map.get(key);
			i++;
		}

		
		return tags;
	}

	public static List<List<Integer>> rank(int[] tags) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		
		return lists;

	}
}
