package com.axisbank;

import java.util.TimeZone;
import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication(scanBasePackages = {"com.axisbank"})
@EnableAsync
@Configuration
@EnableCaching
@EnableAspectJAutoProxy
public class LimitenhancementApplication {

    public static void main(String[] args) {
        SpringApplication.run(LimitenhancementApplication.class, args);
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

   /* @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("configMapCache");
    }
*/
    /*@Bean
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        return executor;
    }*/
}
