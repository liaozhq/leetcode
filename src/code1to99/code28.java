package code1to99;

public class code28 {
	public static void main(String[] args) {
		System.out.println(strStr("mississippi", "issip"));
	}

	public static int strStr(String haystack, String needle) {

		if (haystack.length() == 0 && needle.length() == 0) {
			return 0;
		}

		if (needle.length() == 0) {
			return 0;
		}

		if (haystack.length() == 0 || needle.length() > haystack.length()) {
			return -1;
		}

		int key = 0;
		int cur = 0;
		boolean visit = false;
		for (int i = 0; i < haystack.length(); i++) {
			if (haystack.charAt(i) == needle.charAt(key)) {
				if (key == 0) {
					cur = i;
				}
				visit = true;
				key++;
				if (key == needle.length()) {
					break;
				}
			} else {
				visit = false;
				key = 0;
			}
		}

		if (visit) {
			return cur;
		} else {
			return -1;
		}
	}
}
