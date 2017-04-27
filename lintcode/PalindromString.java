package lintcode;

public class PalindromString {

	public static void main(String[] args) {
		String s = "ccc";
		String result = parlindromString(s);
		System.out.println(result);
	}

	public static String parlindromString(String s) {
		int max = 0;
		int startIndex = 0;
		int endIndex = 0;
		for (int i = 1; i < s.length(); i++) {
			int current = 1;
			for (int j = 1; j <= s.length() / 2; j++) {
				if (i - j >= 0 && i + j < s.length() && s.charAt(i - j) == s.charAt(i + j)) {
					current += 2;
					if (current > max) {
						max = current;
						startIndex = i - j;
						endIndex = i + j;
					}
				} else {
					break;
				}
			}
		}
		for (int i = 0; i < s.length() - 1; i++) {
			int current = 0;
			for (int j = 0; j <= s.length() / 2; j++) {
				if (i - j >= 0 && i + 1 + j < s.length() && s.charAt(i - j) == s.charAt(i + 1 + j)) {
					current += 2;
					if (current > max) {
						max = current;
						startIndex = i - j;
						endIndex = i + 1 + j;
					}
				} else {
					break;
				}
			}
		}
		String result = s.substring(startIndex, endIndex + 1);
		return result;
	}

}
