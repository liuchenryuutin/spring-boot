package lc.cy.framework.web;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.SimpleThreadScope;

import lc.cy.framework.constant.Constant;

@Configuration
public class WebSpringBootApplication {

//	@Bean
//	public FilterRegistrationBean<CharacterEncodingFilter> characterEncodingFilter(WebProperties properties) {
//		FilterRegistrationBean<CharacterEncodingFilter> filterRegistrationBean = new FilterRegistrationBean<CharacterEncodingFilter>();
//		filterRegistrationBean.setFilter(new CharacterEncodingFilter(properties.getCode(), true));
//		filterRegistrationBean.addUrlPatterns("/*");
//		filterRegistrationBean.setName("characterEncodingFilter");
//		filterRegistrationBean.setOrder(1);
//		return filterRegistrationBean;
//	}

	@Bean
	public CustomScopeConfigurer customScopeConfigurer() {
		CustomScopeConfigurer configurer = new CustomScopeConfigurer();
		configurer.addScope(Constant.Scope.Thread, new SimpleThreadScope());
		return configurer;
	}
}
