package lc.cy.framework.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import lc.cy.framework.properties.SecurityProperties;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private SecurityProperties securityProperties;

//	@Autowired
//	private AuthenticationProvider authenticationProvider;
//
//	@Autowired
//	private LogoutHandler logoutHandler;
//
//	@Autowired
//	private InvalidSessionStrategy invalidSessionStrategy;
//
//	@Autowired
//	private SessionAuthenticationStrategy sas;
//
//	@Autowired
//	private AuthenticationSuccessHandler standAuthenticationSuccessHandler;
//
//	@Autowired
//	private LogoutSuccessHandler logoutSuccessHandler;

//	@Autowired
//	private StandAuthenticationSetting standAuthenticationSetting;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.authenticationProvider(authenticationProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		loginConfig(http);
		withoutLogin(http);
//		withinLogin(http);
//		sessionConfig(http);
//		addFilter(http);
	}

	/**
	 * 
	 * @param http
	 * @throws Exception
	 */
	private void withoutLogin(HttpSecurity http) throws Exception {
		String withoutLogin = securityProperties.getWithoutlogin();
		String[] withoutLogins = withoutLogin.split(",");
		http.authorizeRequests().antMatchers(withoutLogins).permitAll();
	}

//	private void withinLogin(HttpSecurity http) throws Exception {
//		String withinLogin = securityProperties.getWithinLoginUrl();
//		String role = securityProperties.getRole();
//		String[] withinLogins = withinLogin.split(",");
//		http.authorizeRequests().antMatchers(withinLogins).hasRole(role);
//	}

//	private void loginConfig(HttpSecurity http) throws Exception {
//		String[] clearingCookies = securityProperties.getLogoutClearCookies().split(";", -1);
//		CookieClearingLogoutHandler cookieClearingLogoutHandler = new CookieClearingLogoutHandler(clearingCookies);
//		http.formLogin().loginPage(securityProperties.getLoginUrl()).and().logout()
//				.logoutUrl(securityProperties.getLogoutUrl()).addLogoutHandler(logoutHandler)
//				.addLogoutHandler(cookieClearingLogoutHandler).logoutSuccessHandler(logoutSuccessHandler)
//				.invalidateHttpSession(true).and();
//	}
//
//	private void sessionConfig(HttpSecurity http) throws Exception {
//		http.sessionManagement().invalidSessionStrategy(invalidSessionStrategy);
//	}
//
//	private void addFilter(HttpSecurity http) throws Exception {
//		SecurityUserPasswordAuthenticationFilter securityUserPasswordAuthenticationFilter = new SecurityUserPasswordAuthenticationFilter();
//		securityUserPasswordAuthenticationFilter.setRequiresAuthenticationRequestMatcher(
//				new AntPathRequestMatcher(securityProperties.getLoginUrl(), "POST"));
//		securityUserPasswordAuthenticationFilter.setStandAuthenticationSetting(standAuthenticationSetting);
//		securityUserPasswordAuthenticationFilter.setAuthenticationManager(super.authenticationManagerBean());
//		securityUserPasswordAuthenticationFilter.setAuthenticationSuccessHandler(standAuthenticationSuccessHandler);
//		securityUserPasswordAuthenticationFilter.setSessionAuthenticationStrategy(sas);
//		securityUserPasswordAuthenticationFilter.setAuthenticationFailureHandler(
//				new SimpleUrlAuthenticationFailureHandler(securityProperties.getLoginFaildUrl()));
//		securityUserPasswordAuthenticationFilter.setUsernameParameter(securityProperties.getUserId());
//		securityUserPasswordAuthenticationFilter.setPasswordParameter(securityProperties.getPasswardId());
//		http.addFilterAt(securityUserPasswordAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//
//	}

}
