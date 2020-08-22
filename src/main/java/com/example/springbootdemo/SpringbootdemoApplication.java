package com.example.springbootdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 启动类
 * @author xiaojie xiaojie
 * 此处必须加入MapperScan注解，前面根据自己项目来更改即可
 */
@SpringBootApplication
@MapperScan("com.example.springbootdemo.**.mapper")
public class SpringbootdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootdemoApplication.class, args);
    }

}
