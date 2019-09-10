package lc.cy.framework.util;

public abstract class CommonUtil {

	public static boolean isEmpty(Object object) {
		if (object == null) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty(String str) {
		if (str == null || str.length() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 去除字符串的右空格
	 * 
	 * @param 需要去除的字符串
	 * @return 变换之后的字符串
	 */
	public static String rightTrim(String value) {
		if (isEmpty(value)) {
			return value;
		}
		char[] ch = value.toCharArray();
		int pos = ch.length - 1;
		while (ch[pos] == ' ') {
			pos--;
		}
		return value.substring(0, pos + 1);
	}
}
