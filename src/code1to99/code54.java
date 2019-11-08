package code1to99;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。 示例 1:
 * 
 * 输入: [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ] 输出: [1,2,3,6,9,8,7,4,5] 示例 2:
 * 
 * 输入: [ [1, 2, 3, 4], [5, 6, 7, 8], [9,10,11,12], [13,14,15,16] ] 输出:
 * [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 * 
 * @author lzq 解题思路：首先
 */
public class code54 {

	public static void main(String[] args) {
		System.out.println(
				spiralOrder(new int[][] { { 2},
					                      { 3}}));
	}

	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<Integer>();
		int row = matrix.length;
		if (row < 1) {
			return list;
		}
		int column = matrix[0].length;
		boolean[][] visit = new boolean[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				visit[i][j] = false;
			}
		}
		dfs(list, matrix, visit, 0, 0);
		return list;
	}

	public static void dfs(List<Integer> list, int[][] matrix, boolean[][] visit, int x, int y) {
		int width = visit.length - 1;
		int height = visit[0].length - 1;

		if (x > width || y > height || x < 0 || y < 0) {
			return;
		}

		if (visit[x][y]) {
			return;
		}

		list.add(matrix[x][y]);
		visit[x][y] = true;
		if (y < height && !visit[x][y + 1] && x == 0
				|| y < height && !visit[x][y + 1] && x < width && x > 0 && visit[x - 1][y]) { // 右
			dfs(list, matrix, visit, x, y + 1);
		} else if (x < width && !visit[x + 1][y]) { // 下
			dfs(list, matrix, visit, x + 1, y);
		} else if ((x > 0 && visit[x - 1][y] && x == width && y > 0 && !visit[x][y-1]) || (y < height && visit[x][y + 1] && y > 0 && !visit[x][y-1])) { // 左
			dfs(list, matrix, visit, x, y - 1);
		} else { // 上
			dfs(list, matrix, visit, x - 1, y);
		}

	}
}
