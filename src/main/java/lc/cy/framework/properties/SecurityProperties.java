package lc.cy.framework.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:properties/security.properties")
@ConfigurationProperties(prefix = "login")
public class SecurityProperties {

	private String initUrl;

	private String processerUrl;

	private String withoutlogin;

	/**
	 * @return the initUrl
	 */
	public String getInitUrl() {
		return initUrl;
	}

	/**
	 * @param initUrl the initUrl to set
	 */
	public void setInitUrl(String initUrl) {
		this.initUrl = initUrl;
	}

	/**
	 * @return the processerUrl
	 */
	public String getProcesserUrl() {
		return processerUrl;
	}

	/**
	 * @param processerUrl the processerUrl to set
	 */
	public void setProcesserUrl(String processerUrl) {
		this.processerUrl = processerUrl;
	}

	/**
	 * @return the withoutlogin
	 */
	public String getWithoutlogin() {
		return withoutlogin;
	}

	/**
	 * @param withoutlogin the withoutlogin to set
	 */
	public void setWithoutlogin(String withoutlogin) {
		this.withoutlogin = withoutlogin;
	}

}
