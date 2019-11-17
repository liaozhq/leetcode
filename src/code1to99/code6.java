package code1to99;

public class code6 {

	public static void main(String[] args) {
		System.out.println(convert("AB", 1));
	}

	public static String convert(String s, int numRows) {
		// 计算有多少列
		char[] chars = s.toCharArray();
		int column = 1; // 列

		int i = 1;
		int element = 1;
		int t = 1;

		if (numRows > 3) {
			t += numRows - 3;
		}else {
			column = numRows;
		}

		while (element < chars.length) {
			if (i % 3 == 0) {
				i = 1;
				column += i + t;
				element += t;
			}
			i++;
			element++;
		}

		char[][] array = new char[numRows][column];
		for (int k = 0; k < array.length; k++) {
			for (int j = 0; j < array[0].length; j++) {
				array[k][j] = '.';
			}
		}

		element = 1;
		int row = 1;
		int col = 1;
		boolean isFlag = true;
		while (element <= chars.length) {
			if (numRows == 1) {
				array[row - 1][col - 1] = chars[element - 1];
				row++;
			} else {
				if (isFlag) {
					array[row - 1][col - 1] = chars[element - 1];
					if (row == numRows) {
						isFlag = false;
					} else {
						row++;
					}
				} else {
					col = col + 1;
					row--;
					if (row > 0 && col > 0) {
						array[row - 1][col - 1] = chars[element - 1];
						if (row == 1) {
							isFlag = true;
							row++;
						}
					}
				}
			}
			element++;
		}

		StringBuilder build = new StringBuilder();

		for (int k = 0; k < array.length; k++) {
			for (int j = 0; j < array[0].length; j++) {
				String value = String.valueOf(array[k][j]);
				if (!".".equals(String.valueOf(value))) {
					build.append(array[k][j]);
				}
			}
		}

		return build.toString();
	}
}
