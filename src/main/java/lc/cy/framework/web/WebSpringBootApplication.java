package lc.cy.framework.web;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

import lc.cy.framework.properties.WebProperties;

@Configuration
@EnableConfigurationProperties(WebProperties.class)
public class WebSpringBootApplication {

	@Bean
	public FilterRegistrationBean<CharacterEncodingFilter> characterEncodingFilter(WebProperties properties) {
		FilterRegistrationBean<CharacterEncodingFilter> filterRegistrationBean = new FilterRegistrationBean<CharacterEncodingFilter>();
		filterRegistrationBean.setFilter(new CharacterEncodingFilter(properties.getCode(), true));
		filterRegistrationBean.addUrlPatterns("/*");
		filterRegistrationBean.setName("characterEncodingFilter");
		filterRegistrationBean.setOrder(1);
		return filterRegistrationBean;
	}

}
