package com.kingdee.dome;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.kingdee.dome.dao")
@EnableTransactionManagement
@EnableCaching
@SpringBootApplication
@EnableScheduling
public class DomeApplication  extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DomeApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DomeApplication.class);
    }
}
