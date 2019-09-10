package lc.cy.framework.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:properties/security.properties")
@ConfigurationProperties(prefix = "login")
public class SecurityProperties {

	private String initUrl;

	private String rocesserUrl;

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
	 * @return the rocesserUrl
	 */
	public String getRocesserUrl() {
		return rocesserUrl;
	}

	/**
	 * @param rocesserUrl the rocesserUrl to set
	 */
	public void setRocesserUrl(String rocesserUrl) {
		this.rocesserUrl = rocesserUrl;
	}

}
