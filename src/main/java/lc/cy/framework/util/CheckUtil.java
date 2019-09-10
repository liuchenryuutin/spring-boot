package lc.cy.framework.util;

public class CheckUtil {

	public static boolean isNumber(String value) {
		for (int i = 0; i < value.length(); i++) {
			char ch = value.charAt(i);
			if (ch < 48 || ch > 57) {
				return false;
			}
		}
		return true;
	}

	public static String inputCheckByType(String value, String type) {

		String message = "";
		if (CommonUtil.isEmpty(type)) {
			return message;
		}
		String[] typeList = type.split(":");

		message = checkDN(value, typeList);

		if (!"".equals(message)) {
			return message;
		}
		return message;
	}

	/**
	 * 输入值必须为数字，且长度不能超过指定大小
	 * 
	 * @param value 输入值
	 * @param type  类型(DN:2)
	 * @return
	 */
	public static String checkDN(String value, String[] type) {
		String error = "";
		if (!CommonUtil.isEmpty(type)) {
			if (type.length > 1) {
				if ("NT".equals(type[0])) {
					if (CommonUtil.isEmpty(value)) {
						error = "输入值不能为空(数字)";
					}
					if (!isNumber(value) || !isNumber(type[1]) || value.length() > Integer.parseInt(type[1])) {
						error = "请输入" + type[1] + "位以内的数字！";
					}
				}
			}
		}
		return error;
	}
}
