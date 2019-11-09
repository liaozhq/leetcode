package code1to99;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * 
 * 数字 1-9 在每一行只能出现一次。 数字 1-9 在每一列只能出现一次。 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 
 * 
 * 上图是一个部分填充的有效的数独。
 * 
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * 
 * 示例 1:
 * 
 * 输入: [ ["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."], [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"], ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"], [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"], [".",".",".",".","8",".",".","7","9"]
 * ] 输出: true 示例 2:
 * 
 * 输入: [   ["8","3",".",".","7",".",".",".","."],  
 * ["6",".",".","1","9","5",".",".","."],  
 * [".","9","8",".",".",".",".","6","."],  
 * ["8",".",".",".","6",".",".",".","3"],  
 * ["4",".",".","8",".","3",".",".","1"],  
 * ["7",".",".",".","2",".",".",".","6"],  
 * [".","6",".",".",".",".","2","8","."],  
 * [".",".",".","4","1","9",".",".","5"],  
 * [".",".",".",".","8",".",".","7","9"] ] 输出: false 解释: 除了第一行的第一个数字从 5 改为 8
 * 以外，空格内其他数字均与 示例1 相同。 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。 说明:
 * 
 * 一个有效的数独（部分已被填充）不一定是可解的。 只需要根据以上规则，验证已经填入的数字是否有效即可。 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 给定数独永远是 9x9 形式的。
 */
public class code36 {

	public static void main(String[] args) {
		System.out.println(isValidSudoku(new char[][] {
			{'5','3','.','.','7','.','.','.','.'},
			{'6','.','.','1','9','5','.','.','.'},
			{'.','9','5','.','.','.','.','6','.'},
			{'8','.','.','.','6','.','.','.','3'},
			{'4','.','.','8','.','3','.','.','1'},
			{'7','.','.','.','2','.','.','.','6'},
			{'.','6','.','.','.','.','2','8','.'},
			{'.','.','.','4','1','9','.','.','5'},
			{'.','.','.','.','8','.','.','7','9'}
			 }));
	}

	public static boolean isValidSudoku(char[][] board) {
		int row = board.length;
		int column = board[0].length;

		if (row != 9 || column != 9) {
			return false;
		}

		for (int i = 0; i < row; i++) {
			List<Object> list = new ArrayList<Object>();
			for (int j = 0; j < column; j++) {
				if (board[i][j] != '.') {
					if (list.contains(board[i][j])) {
						return false;
					}
					list.add(board[i][j]);
				}
			}
		}

		for (int j = 0; j < column; j++) {
			List<Object> list = new ArrayList<Object>();
			for (int i = 0; i < row; i++) {
				if (board[i][j] != '.') {
					if (list.contains(board[i][j])) {
						return false;
					}
					list.add(board[i][j]);
				}
			}
		}


		List<char[][]> charlist = new ArrayList<char[][]>();

		for (int i = 1; i <= 9; i++) { // 将9宫格分成3*3九个数组
			int subrow = 3;
			int subcolumn = 3;
			if (i > 3 && i <= 6) {
				subrow = subrow * 2;
			} else if (i > 6) {
				subrow = subrow * 3;
			}

			subcolumn = (i % 3 == 0) ? subcolumn * 3 : (i % 3) * subcolumn;

			char[][] chars = new char[3][3];
			for (int a = 0, r = (i <= 3 ? 0 : i > 3 && i <= 6 ? 3 : 6) ; r < subrow; a++, r++) {
				for (int b = 0, c = subcolumn - 3; c < subcolumn; b++, c++) {
					char value = board[r][c];
					chars[a][b] = value;
				}
			}

			charlist.add(chars);
		}
		
		for(int p = 1 ; p <= 9 ; p++) {
			char[][] chars = charlist.get(p-1);

				for (int i = 0; i < chars.length; i++) {
					for (int j = 0; j < chars[0].length; j++) {
						System.out.print(chars[i][j]+",");
					}
					System.out.println();
				}
			System.out.println("-------------------");
		}

		for (char[][] chars : charlist) {
			List<Object> list = new ArrayList<Object>();
			for (int i = 0; i < chars.length; i++) {
				for (int j = 0; j < chars[0].length; j++) {
					if (chars[i][j] != '.') {
						if (list.contains(chars[i][j])) {
							return false;
						}
						list.add(chars[i][j]);
					}
				}
			}
		}

		return true;
	}
}
