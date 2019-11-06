package com.shen.uac;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan({ "com.shen.uac.dao" })
@SpringBootApplication
public class UacApplication {

	public static void main(String[] args) {
		SpringApplication.run (UacApplication.class, args);
	}
}
