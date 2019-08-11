package com.marrry;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: marry
 * @description: 启动类
 * @author: Mr.Bob
 * @create: 2019-08-09 10:32
 **/
@SpringBootApplication
public class Application {
    private static  final Logger log=LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
        log.info("项目启动了");
    }
}
