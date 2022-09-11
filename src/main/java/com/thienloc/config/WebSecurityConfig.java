package com.thienloc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.thienloc.service.UserDetailsServiceImpl;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsServiceImpl userDetailsService;
	
	AppConfig appConfig = new AppConfig();
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(appConfig.passwordEncoder());
    }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable();
//		http.authorizeRequests()
//			.antMatchers("/", "/sanpham/**", "/danhmuc/**", "/blog/**", "/shopping-cart", "/checkout", "/shopping-guide", "/css/**", "/js/**", "/fonts/**", "/img/**", "/sass/**" )
//		.permitAll()
//		.anyRequest().authenticated().and()
//		.formLogin().loginPage("/login").permitAll();

		http.csrf().disable();

		// Các yêu cầu phải login với vai trò ROLE_EMPLOYEE hoặc ROLE_MANAGER.
		// Nếu chưa login, nó sẽ redirect tới trang /admin/login.
		http.authorizeRequests().antMatchers("/admin/**").access("hasAnyRole('ROLE_EMPLOYEE', 'ROLE_MANAGER')");

		// Các trang chỉ dành cho MANAGER
//		http.authorizeRequests().antMatchers("/admin/product").access("hasRole('ROLE_MANAGER')");

		// Khi người dùng đã login, với vai trò XX.
		// Nhưng truy cập vào trang yêu cầu vai trò YY,
		// Ngoại lệ AccessDeniedException sẽ ném ra.
		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

		// Cấu hình cho Login Form.
		http.authorizeRequests().and().formLogin()//
			.loginProcessingUrl("/j_spring_security_check") // Submit URL
			.loginPage("/admin/login").permitAll()//
			.defaultSuccessUrl("/admin/thienloc")//
			.failureUrl("/admin/login?error=true")//
			.usernameParameter("userName")//
			.passwordParameter("password")

			// Cấu hình cho trang Logout.
			// (Sau khi logout, chuyển tới trang home)
			.and().logout().logoutUrl("/admin/logout").logoutSuccessUrl("/");

	}
}