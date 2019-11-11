package code1to99;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * 
 * candidates 中的数字可以无限制重复被选取。
 * 
 * 说明：
 * 
 * 所有数字（包括 target）都是正整数。 解集不能包含重复的组合。  示例 1:
 * 
 * 输入: candidates = [2,3,6,7], target = 7, 所求解集为: [ [7], [2,2,3] ] 示例 2:
 * 
 * 输入: candidates = [2,3,5], target = 8, 所求解集为: [   [2,2,2,2],   [2,3,3],  
 * [3,5] ]
 * 
 */
public class code39 {
	public static void main(String[] args) {
		System.out.println(combinationSum(new int[] { 7, 3, 2 }, 18));
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		int length = candidates.length;

		int yxcd = 0;

		for (int i = 0; i < length; i++) {
			if (candidates[i] <= target) {
				yxcd++;
			}
		}

		int[] yxsz = new int[yxcd];

		for (int i = 0, cd = 0; i < length; i++) {
			if (candidates[i] <= target) {
				yxsz[cd] = candidates[i];
				cd++;
			}
		}

		boolean[] visit = new boolean[yxcd];
		for (int i = 0; i < visit.length; i++) {
			visit[i] = false;
		}

		return dfs(lists, visit, yxsz, target);
	}

	public static List<List<Integer>> dfs(List<List<Integer>> lists, boolean[] visit, int[] yxsz, int target) {
		for (int i = 0; i < yxsz.length; i++) {
			List<Integer> list = new ArrayList<Integer>();
			int cnt = 0;
			while (cnt < target) {
				int num = yxsz[i];
				cnt += num;
				list.add(num);
				if (num != 0) {
					boolean[] subvisit = new boolean[visit.length];
					for (int r = 0; r < subvisit.length; r++) {
						subvisit[r] = false;
					}
					subvisit[i] = true;
					List<List<Integer>> sublists = calc(list, subvisit, yxsz, target);
					if (sublists != null) {
						for (List<Integer> sublist : sublists) {
							if (!lists.contains(sublist)) {
								lists.add(sublist);
							}
						}
					}
				}
				if (cnt == target) {
					list.sort(new compara());
					if (!lists.contains(lists)) {
						lists.add(list);
					}
				}
			}
			visit[i] = true;
		}
		return lists;
	}

	private static class compara implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o1.compareTo(o2);
		}

	}

	public static List<List<Integer>> calc(List<Integer> tmplist, boolean[] visit, int[] yxsz, int target) {
		boolean flag = true;
		for (boolean b : visit) {
			if (!b) {
				flag = false;
			}
		}
		if(flag) {
			return null;
		}
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		int sum = 0;
		for (Integer num : tmplist) {
			list.add(num);
			sum += num;
		}

		for (int i = 0; i < visit.length; i++) {
			if (!visit[i]) {
				int subsum = sum;
				List<Integer> sublist = new ArrayList<Integer>();
				for (Integer num : list) {
					sublist.add(num);
				}

				boolean[] subvisit = new boolean[visit.length];
				int k = 0;
				for (boolean b : visit) {
					subvisit[k] = b;
					k++;
				}
				subvisit[i] = true;

				while (subsum < target) {
					subsum += yxsz[i];
					sublist.add(yxsz[i]);
					List<List<Integer>> backlist = calc(sublist, subvisit, yxsz, target);
					if (backlist != null) {
						for (List<Integer> subbacklist : backlist) {
							lists.add(subbacklist);
						}
					}
					if (subsum == target) {
						sublist.sort(new compara());
						lists.add(sublist);
					}
				}
			}
		}
		return lists;
	}
}
