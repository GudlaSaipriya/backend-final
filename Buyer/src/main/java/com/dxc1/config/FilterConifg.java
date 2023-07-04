package com.dxc1.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.GenericFilterBean;

import com.dxc1.filter.JWTValidationFilter;


@Configuration
public class FilterConifg {

public static final String BUYER_PATH = "/orderbybuyer/*";
	
	@Bean
	public FilterRegistrationBean<GenericFilterBean> jwtFilter(){
		FilterRegistrationBean<GenericFilterBean> filterRegistrationBean = new FilterRegistrationBean<>();
		filterRegistrationBean.setFilter(new JWTValidationFilter());
		filterRegistrationBean.addUrlPatterns(BUYER_PATH);
		return filterRegistrationBean;
	}
}

