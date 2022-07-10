package com.mysql.shiori;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mysql.shiori.mapper")
public class MysqlTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MysqlTestApplication.class, args);
	}

}
