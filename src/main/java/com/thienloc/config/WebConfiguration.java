package com.thienloc.config;

import java.util.concurrent.TimeUnit;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        // Register resource handler for images
        registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/images/");
//                .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
    }
	
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		// Tải file: validation.properties
		messageSource.setBasename("classpath:validation");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}
 
}