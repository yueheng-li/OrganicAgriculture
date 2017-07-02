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

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
        super.addResourceHandlers(registry);
    }
}
