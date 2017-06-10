package com.organic.agriculture.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.organic.agriculture.common.interceptor.AuthSessionInterceptor;
import com.organic.agriculture.common.interceptor.ErrorInterceptor;

@EnableWebMvc
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = { "classpath:/WEB-INF/static/",
            "classpath:/resources/", "classpath:/static/", "classpath:/public/" };


    /**
     * filter 設定
     * 
     */
//    @Bean
//    public FilterRegistrationBean filterRegistration() {
//
//        FilterRegistrationBean registration = new FilterRegistrationBean();
////        registration.setFilter(new SecurityFilter());
////        registration.addUrlPatterns("/*");
////        registration.addInitParameter("paramName", "paramValue");
////        registration.setName("LoginFilter");
////        registration.setOrder(1);
//        return registration;
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns ルート追加
        registry.addInterceptor(new ErrorInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new AuthSessionInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
        super.addResourceHandlers(registry);
    }



}
