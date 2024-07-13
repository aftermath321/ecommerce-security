package com.security.securityecommerce;


import com.security.securityecommerce.filters.SecurityFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {

    @Bean
    public FilterRegistrationBean<SecurityFilter> securityFilterFilterRegistrationBean (){
    FilterRegistrationBean<SecurityFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new SecurityFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("Security Filter");
        registrationBean.setOrder(1);
    return registrationBean;
    }

}
