package com.demo.feign.config;

import feign.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    @Bean
    public Request.Options feignOptions() {
        // 设置连接超时时间为5秒，读取超时时间为10秒
        return new Request.Options(50000, 60000);
    }

    @Bean
    public Retryer feignRetryer() {
        // 设置重试策略
        return new Retryer.Default(100, java.util.concurrent.TimeUnit.SECONDS.toMillis(1), 3);
    }

    @Bean
    public Logger.Level loggerLevel() {
        // 设置日志级别为FULL以便于调试
        return Logger.Level.FULL;
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate template) {
                // 权限
                template.header("Authorization", "Bearer sk-33ad04c4d8ce491c9dc8d2d7b9851b5d");
                // key
                template.header("Content-Type", "application/json");
            }
        };
    }
}
