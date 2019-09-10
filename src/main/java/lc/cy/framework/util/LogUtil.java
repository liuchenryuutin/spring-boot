package lc.cy.framework.util;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lc.cy.framework.scope.ThreadScope;

@Component
public class LogUtil {

	private static ThreadScope threadScope;

	private static Logger accessLogger = LoggerFactory.getLogger("ACCESSLOG");

	private static Logger errorLogger = LoggerFactory.getLogger("ERRORLOG");

	public static final String CONTROLLER_HEAD = "[CONTROLLER] ";

	public static final String SERVICE_HEAD = "[SERVICE]";

	public static final String DAO_HEAD = "[DAO]";

	public static final String REQUEST_HEAD = "[REQUEST]";

	public static final String RESPONSE_HEAD = "[RESPONSE]";

	public static final String DEFAULT = "NULL";

	public static final String CONTROLLER_START = "CONSTROLLER START";

	public static final String CONTROLLER_END = "CONSTROLLER END";

	@Autowired
	public void setThreadScope(ThreadScope scope) {
		LogUtil.threadScope = scope;
	}

	/**
	 * 打印ACCESS级别log
	 * 
	 * @param message
	 */
	public static void accessLog(String message) {
		if (accessLogger.isInfoEnabled()) {
			accessLogger.info(message);
		}
	}

	/**
	 * 取得controller类名和方法名
	 * 
	 * @return
	 */
	public static String getControllerClassMethodName() {
		String logStr = "";
		String controllerClassName = DEFAULT;
		if (!CommonUtil.isEmpty(threadScope.getControllerName())) {
			controllerClassName = threadScope.getControllerName();
			logStr = logStr + controllerClassName + ".";
		}
		String controllerMethodName = DEFAULT;
		if (!CommonUtil.isEmpty(threadScope.getControllerMethodName())) {
			controllerMethodName = threadScope.getControllerMethodName();
			logStr = logStr + controllerMethodName;
		}
		return logStr;
	}

	/**
	 * 打印controller层信息
	 * 
	 * @param message
	 * @return
	 */
	public static String controllerLogPart(String message) {
		String logStr = CONTROLLER_HEAD;
		logStr = logStr + getControllerClassMethodName() + " " + message;
		return logStr;
	}

	/**
	 * 打印请求信息
	 * 
	 * @param request
	 * @return
	 */
	public static String requestLogPart(HttpServletRequest request) {
		StringBuffer logStr = new StringBuffer();
		logStr.append(REQUEST_HEAD);
		String url = request.getRequestURI();
		String method = request.getMethod();
		String host = request.getRemoteHost();
		String sessionId = request.getSession().getId();
		Cookie[] cookies = request.getCookies();
		Map<String, String[]> map = request.getParameterMap();

		logStr.append("\n请求url:").append(url);
		logStr.append("\n请求方法:").append(method);
		logStr.append("\n请求host:").append(host);
		logStr.append("\n请求sessionid:").append(sessionId);
		if (!CommonUtil.isEmpty(cookies)) {
			logStr.append("\n请求cookie:{");
			for (int i = 0; i < cookies.length; i++) {
				if (i == 0) {
					logStr.append("[键:").append(cookies[i].getName()).append(" 值:").append(cookies[i].getValue())
							.append("]");
				} else {
					logStr.append(";[键:").append(cookies[i].getName()).append(" 值:").append(cookies[i].getValue())
							.append("]");
				}
			}
			logStr.append("}\n");
		} else {
			logStr.append("\n请求cookie:{null}\n");
		}

		boolean first = true;
		if (!CommonUtil.isEmpty(map)) {
			logStr.append("请求参数:{\n");
			for (Map.Entry<String, String[]> entry : map.entrySet()) {
				if (first) {
					logStr.append("    [键:").append(entry.getKey()).append(" 值:")
							.append(String.join(" | ", entry.getValue())).append("]");
					first = false;
				}
				logStr.append("\n    [键:").append(entry.getKey()).append(" 值:")
						.append(String.join(" | ", entry.getValue())).append("]");
			}
			logStr.append("}");
		} else {
			logStr.append("请求参数:{null}");
		}
		return logStr.toString();
	}

	public static String responseLogPart(HttpServletResponse response) {
		StringBuffer logStr = new StringBuffer();
		logStr.append(RESPONSE_HEAD);
		int status = response.getStatus();
		logStr.append("\n响应码:").append(status);
		// String cookie = response.getHeader();
		return logStr.toString();
	}
}
