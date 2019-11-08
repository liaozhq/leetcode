package code1to99;

/**
 * 
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？ 说明：m 和 n 的值均不超过 100。
 * 
 * 示例 1:
 * 
 * 输入: [   [0,0,0],   [0,1,0],   [0,0,0] ] 输出: 2 解释: 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径： 1. 向右 -> 向右 -> 向下 -> 向下 2. 向下 -> 向下 -> 向右 -> 向右
 * 
 */
public class code63 {

	public static void main(String[] args) {
		System.out.println(uniquePathsWithObstacles(new int[][] { { 0, 0 }, { 0, 1 }, { 0, 0 } }));
	}

	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int row = obstacleGrid.length;
		int column = obstacleGrid[0].length;
		if (row == 1 || column == 1) {
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					if (obstacleGrid[i][j] == 1)
						return 0;
				}
			}
			return 1;
		}

		int[][] dp = new int[row][column];
		if (obstacleGrid[0][0] == 1) { // 如果入口处有障碍物就没有路,直接返回0
			return 0;
		} else {
			dp[0][0] = 1;
		}
		for (int i = 1; i < row; i++) { 
			if (obstacleGrid[i][0] == 1) {
				dp[i][0] = 0;
			} else {
				if (dp[i - 1][0] == 0) { //如果上边有障碍物，则这是条死路
					dp[i][0] = 0;
				} else {
					dp[i][0] = 1;
				}
			}
		}

		for (int i = 1; i < column; i++) {
			if (obstacleGrid[0][i] == 1) {
				dp[0][i] = 0;
			} else {
				if (dp[0][i - 1] == 0) { //如果左边是有障碍物，则这是条死路
					dp[0][i] = 0;
				} else {
					dp[0][i] = 1;
				}
			}
		}

		for (int i = 1; i < row; i++) {
			for (int j = 1; j < column; j++) {
				dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1];
			}
		}

		return dp[row - 1][column - 1];

	}
}
