package com.somupvotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SomUpvotesApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(SomUpvotesApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
