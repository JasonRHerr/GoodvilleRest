package com.company.goodville.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class GoodvilleRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoodvilleRestApplication.class, args);
		System.out.println("We've made it in.");
	}
}
