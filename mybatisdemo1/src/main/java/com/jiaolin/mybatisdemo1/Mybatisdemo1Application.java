package com.jiaolin.mybatisdemo1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jiaolin.mybatisdemo1.mapper")
public class Mybatisdemo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Mybatisdemo1Application.class, args);
    }

}
