package code1to99;

import java.util.ArrayList;
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
	
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		int length = candidates.length;
		
		int yxcd = 0;
		
		for (int i = 0; i < length; i++) {
			if(candidates[i] <= target) {
				yxcd++;
			}
		}
		
		int[] yxsz = new int[yxcd];

		for (int i = 0 , cd = 0; i < length; i++) {
			if(candidates[i] <= target) {
				yxsz[i] = candidates[i];
				cd++;
			}
		}

		return lists;
	}
	
	public List<Integer> dfs(List<Integer> list, boolean[] visit, int[] yxsz, int target) {
		
	}
}
