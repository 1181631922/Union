package com.education.union;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.education.union.dao")
public class UnionApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
//        SpringApplication.run(SupplierApplication.class, args);
        SpringApplication application=new SpringApplication(UnionApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(UnionApplication.class);
    }

}
