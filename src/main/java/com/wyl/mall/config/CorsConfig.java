package com.wyl.mall.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 解决跨域问题
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {//实现接口或者继承extends WebMvcConfigurationSupport
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        System.out.println("addcrosMapping");
        registry.addMapping("/**")//配置可以被跨域的路径
                .allowedOrigins("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(true)
                .maxAge(3600)
                .allowedHeaders("*");
    }

}
