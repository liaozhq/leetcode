package code1to99;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 
 * 每行中的整数从左到右按升序排列。 每行的第一个整数大于前一行的最后一个整数。 示例 1:
 * 
 * 输入: matrix = [ [1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50] ] target = 3
 * 输出: true 示例 2:
 * 
 * 输入: matrix = [ [1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50] ] target = 13
 * 输出: false
 * 
 */
public class code74 {

	public static void main(String[] args) {
		System.out.println(searchMatrix(new int[][] { {1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50} }, 12));
	}

	/**
	 * 解提思路:双重二分法
	 * */
	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix.length == 1 && matrix[0].length == 0) {
			return false;
		}
		
		int rowlength = matrix.length;
		int start = 0, end = rowlength - 1;
		int row = rowlength - 1;
		
		//第一次二分根据每行的第一个数字选择行的数组
		if (matrix.length > 1) {
			while (start <= end) {
				int middler = (start + end) / 2;
				if(matrix[middler][0] == target) { //如果第0个元素等于目标数就直接返回为true
					return true;
				}
				if (middler > 0 && matrix[middler][0] > target && matrix[middler - 1][0] < target) {
					row = middler - 1;
					break;
				} else if (matrix[middler][0] > target) {
					end = middler - 1;
				} else if (matrix[middler][0] < target) {
					start = middler + 1;
				}
			}
		}

		int[] array = matrix[row];
		start = 0;
		end = array.length - 1;
		
		//第二次二分选择的数组再次二分查找
		while (start <= end) {
			int middler = (start + end) / 2;
			if (array[middler] == target) {
				return true;
			} else if (array[middler] > target) {
				end = middler - 1;
			} else if (array[middler] < target) {
				start = middler + 1;
			}
		}

		return false;
	}
}
