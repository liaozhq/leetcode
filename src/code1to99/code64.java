package code1to99;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 
 * 说明：每次只能向下或者向右移动一步。
 * 
 * 示例:
 * 
 * 输入: [   [1,3,1], [1,5,1], [4,2,1] ] 输出: 7 解释: 因为路径 1→3→1→1→1 的总和最小。
 * 
 */
public class code64 {
	public static void main(String[] args) {
		System.out.println(minPathSum(new int[][] { {1,3,1},
			                                        {1,5,1},	  
			                                        {4,2,1},
		}));
	}

	public static int minPathSum(int[][] grid) {

		int row = grid.length;

		if (row == 0) {
			return 0;
		}

		int column = grid[0].length;

		int[][] dp = new int[row][column];

		for (int i = 0; i < row; i++) {
			if (i > 0) {
				dp[i][0] = dp[i - 1][0] + grid[i][0];
			} else {
				dp[i][0] = grid[i][0];
			}
		}

		for (int j = 0; j < column; j++) {
			if (j > 0) {
				dp[0][j] = dp[0][j - 1] + grid[0][j];
			} else {
				dp[0][j] = grid[0][j];
			}
		}

		for (int i = 1; i < row; i++) {
			for (int j = 1; j < column; j++) {
				dp[i][j] = min(dp[i][j - 1] + grid[i][j], dp[i - 1][j] + grid[i][j]);
			}
		}

		return dp[row - 1][column - 1];
	}

	public static int min(int a, int b) {
		return a > b ? b : a;
	}
}
