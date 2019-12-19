package com.project.tms.bookaddicts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "controller")
public class BookAddictsApplication{

    public static void main(String[] args) {
        SpringApplication.run(BookAddictsApplication.class,args);
    }
}
