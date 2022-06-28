package com.jiaolin.mybatis_plus_gene;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jiaolin.mybatis_plus_gene.mapper")
public class MybatisPlusGeneApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusGeneApplication.class, args);
    }

}
