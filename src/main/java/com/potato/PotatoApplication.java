package com.potato;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.hr.stitchpro.entity")
@SpringBootApplication
@EnableTransactionManagement
public class PotatoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PotatoApplication.class, args);
    }

}
