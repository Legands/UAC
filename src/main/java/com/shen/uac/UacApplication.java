package com.shen.uac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan({ "com.shen.uac.dao" })
@ComponentScan("com.shen.uac")
@SpringBootApplication
public class UacApplication {

	public static void main(String[] args) {
		SpringApplication.run (UacApplication.class, args);
	}
}
