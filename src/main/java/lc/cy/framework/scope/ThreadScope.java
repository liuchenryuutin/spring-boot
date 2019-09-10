package lc.cy.framework.scope;

import java.util.Stack;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lc.cy.framework.constant.Constant;

@Component
@Scope(scopeName = Constant.Scope.Thread)
public class ThreadScope {

	private String controllerName;

	private String controllerMethodName;

	private String serviceName;

	private String serviceMethodName;

	private Stack<String> daoName;

	private Stack<String> daoMethodName;

	private String sql;

	/**
	 * @return the controllerName
	 */
	public String getControllerName() {
		return controllerName;
	}

	/**
	 * @param controllerName the controllerName to set
	 */
	public void setControllerName(String controllerName) {
		this.controllerName = controllerName;
	}

	/**
	 * @return the controllerMethodName
	 */
	public String getControllerMethodName() {
		return controllerMethodName;
	}

	/**
	 * @param controllerMethodName the controllerMethodName to set
	 */
	public void setControllerMethodName(String controllerMethodName) {
		this.controllerMethodName = controllerMethodName;
	}

	/**
	 * @return the serviceName
	 */
	public String getServiceName() {
		return serviceName;
	}

	/**
	 * @param serviceName the serviceName to set
	 */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	/**
	 * @return the serviceMethodName
	 */
	public String getServiceMethodName() {
		return serviceMethodName;
	}

	/**
	 * @param serviceMethodName the serviceMethodName to set
	 */
	public void setServiceMethodName(String serviceMethodName) {
		this.serviceMethodName = serviceMethodName;
	}

	/**
	 * @return the daoName
	 */
	public Stack<String> getDaoName() {
		return daoName;
	}

	/**
	 * @param daoName the daoName to set
	 */
	public void setDaoName(Stack<String> daoName) {
		this.daoName = daoName;
	}

	/**
	 * @return the daoMethodName
	 */
	public Stack<String> getDaoMethodName() {
		return daoMethodName;
	}

	/**
	 * @param daoMethodName the daoMethodName to set
	 */
	public void setDaoMethodName(Stack<String> daoMethodName) {
		this.daoMethodName = daoMethodName;
	}

	/**
	 * @return the sql
	 */
	public String getSql() {
		return sql;
	}

	/**
	 * @param sql the sql to set
	 */
	public void setSql(String sql) {
		this.sql = sql;
	}

}
