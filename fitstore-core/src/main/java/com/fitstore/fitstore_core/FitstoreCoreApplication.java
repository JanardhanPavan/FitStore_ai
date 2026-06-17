package com.fitstore.fitstore_core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class FitstoreCoreApplication {

	static {
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/kolkata"));
	}

	public static void main(String[] args) {
		SpringApplication.run(FitstoreCoreApplication.class, args);
	}

}
