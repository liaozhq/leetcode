package code1to99;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 
 * 你可以假设数组中无重复元素。
 * 
 * 示例 1:
 * 
 * 输入: [1,3,5,6], 5 输出: 2 示例 2:
 * 
 * 输入: [1,3,5,6], 2 输出: 1 示例 3:
 * 
 * 输入: [1,3,5,6], 7 输出: 4 示例 4:
 * 
 * 输入: [1,3,5,6], 0 输出: 0

 */
public class code35 {

	public static void main(String[] args) {
		System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 7));
	}

	/**
	 * 非常简单的二分查找法
	 * */
	public static int searchInsert(int[] nums, int target) {
		if (target > nums[nums.length - 1]) { //如果目标数大于数组的最后一位数则返回数的长度
			return nums.length;
		}

		if (target < nums[0]) { //如果目标数小于数组的第一位数这返回0
			return 0;
		}

		int left = 0;
		int right = nums.length - 1;
		int middler = 0;
		while (left <= right) {
			middler = (left + right) / 2;
			if (nums[middler] == target) {
				return middler;
			} else if (nums[middler] > target && nums[middler - 1] < target) {
				return middler;
			}

			if (nums[middler] > target) { //如果中间值大于目标数，则从前半段数组从新循环查找，直到找到为止
				right = middler - 1;
			} else if (nums[middler] < target) { //如果中间值小于目标数，则从后半段数组从新循环查找，直到找到为止
				left = middler + 1;
			}
		}

		return 0;
	}
}
