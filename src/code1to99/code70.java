package code1to99;

import java.util.ArrayList;
import java.util.List;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 
 * 注意：给定 n 是一个正整数。
 * 
 * 示例 1：
 * 
 * 输入： 2 输出： 2 解释： 有两种方法可以爬到楼顶。 1. 1 阶 + 1 阶 2. 2 阶 示例 2：
 * 
 * 输入： 3 输出： 3 解释： 有三种方法可以爬到楼顶。 1. 1 阶 + 1 阶 + 1 阶 2. 1 阶 + 2 阶 3. 2 阶 + 1 阶
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code70 {
	public static void main(String[] args) {
		System.out.println(climbStairs(35));
	}

	public static int climbStairs(int n) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		List<Integer> sz = new ArrayList<Integer>();
		sz.add(1);
		List<Integer> sz2 = new ArrayList<Integer>();
		sz2.add(2);
		List<List<Integer>> backlist1 = Compute(sz, n);
		if (backlist1 != null) {
			lists.addAll(backlist1);
		}
		List<List<Integer>> backlist2 = Compute(sz2, n);
		if (backlist2 != null) {
			lists.addAll(backlist2);
		}
		return lists.size();
	}

	public static List<List<Integer>> Compute(List<Integer> list, int n) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		int sum = 0;
		for (int i : list) {
			sum += i;
		}
		if (n == sum) {
			lists.add(list);
			return lists;
		} else if (sum > n) {
			return null;
		} else {
			List<Integer> sz = new ArrayList<Integer>();
			for (int num : list) {
				sz.add(num);
			}
			sz.add(1);
			List<List<Integer>> backLists = Compute(sz, n);
			if (backLists != null) {
				lists.addAll(backLists);
			}

			List<Integer> sz2 = new ArrayList<Integer>();
			for (int num : list) {
				sz2.add(num);
			}
			sz2.add(2);
			List<List<Integer>> backLists2 = Compute(sz2, n);
			if (backLists2 != null) {
				lists.addAll(backLists2);
			}
			return lists;
		}
	}

}
