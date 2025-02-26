package com.korit.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.korit.basic.dto.Lombok;

@SpringBootApplication
public class BasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicApplication.class, args);
	}

	void method() {
		Lombok lombok1 = new Lombok("a", 1, false, true);
		Lombok lombok2 = new Lombok("a", 1);
	}

}
