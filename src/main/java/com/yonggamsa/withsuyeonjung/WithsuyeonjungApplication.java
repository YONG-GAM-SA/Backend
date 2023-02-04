package com.yonggamsa.withsuyeonjung;

import com.yonggamsa.withsuyeonjung.user.framework.configuration.spring.security.oauth.vo.AppProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(
		AppProperties.class
)
public class WithsuyeonjungApplication {

	public static void main(String[] args) {
		SpringApplication.run(WithsuyeonjungApplication.class, args);
	}

}