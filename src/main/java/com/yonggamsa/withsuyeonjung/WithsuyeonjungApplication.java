package com.yonggamsa.withsuyeonjung;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@RequiredArgsConstructor
@EnableMongoRepositories
public class WithsuyeonjungApplication {

	public static void main(String[] args) {
		SpringApplication.run(WithsuyeonjungApplication.class, args);
	}

}
