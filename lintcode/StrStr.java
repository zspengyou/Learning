package lintcode;

public class StrStr {

	public static final int HASH = 31;
	public static final int MOD = 1000000;

	public static void main(String[] args) {
		StrStr test = new StrStr();
		String source = "abcdefg";
		String target = "bcd";
		int result = test.strStr(source, target);
		System.out.println(result);

	}

	public int strStr(String source, String target) {
		if (source == null || target == null) {
			return -1;
		}
		int length = target.length();
		if (source.length() < length) {
			return -1;
		}
		if (length == 0) {
			return 0;
		}

		int targetHash = getHash(target);
		int sourceHash = getHash(source.substring(0, length));
		if (targetHash == sourceHash) {
			if (target.equals(source.substring(0, length))) {
				return 0;
			}
		}
		int hashConst = 1;
		for (int i = 0; i < length; i++) {// HASH^length
			hashConst *= HASH;
		}
		for (int i = length; i < source.length(); i++) {
			int hashCode = sourceHash * HASH - source.charAt(i - length) * hashConst + source.charAt(i);
			hashCode = getHash(hashCode);
			if (hashCode == targetHash) {
				if (target.equals(source.substring(i - length + 1, i + 1))) {
					return i - length + 1;
				}
			}
		}
		return -1;
	}

	public int getHash(String s) {
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			result = (result + s.charAt(i)) * HASH;
			result = result % MOD;
			result /= HASH;
		}
		return result;
	}

	public int getHash(int hashCode) {
		if (hashCode < 0) {
			hashCode += MOD;
		}
		return hashCode % MOD;
	}

}
