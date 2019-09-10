package lc.cy.framework.web;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lc.cy.framework.constant.Constant;
import lc.cy.framework.interceptor.LoggingInterceptor;
import lc.cy.framework.scope.ThreadScopeConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#
	 * addInterceptors(org.springframework.web.servlet.config.annotation.
	 * InterceptorRegistry)
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LoggingInterceptor log = new LoggingInterceptor();
		registry.addInterceptor(log);
	}

	@Bean
	public CustomScopeConfigurer threadScope() {
		CustomScopeConfigurer configurer = new CustomScopeConfigurer();
		configurer.addScope(Constant.Scope.Thread, new ThreadScopeConfigurer());
		return configurer;
	}
}
