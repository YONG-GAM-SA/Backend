package com.yonggamsa.withsuyeonjung.chatroom.framework.adapters.input.rest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class ChatroomSwaggerConfig {

    private final String basePackage = "com.yonggamsa.withsuyeonjung.chatroom.framework.adapters.input.rest";
    private final String apiTitle = "Map Chat Swagger";
    private final String apiDescription = "Map Chat Chat API";
    private final String apiVersion = "3.0";
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(apiTitle)
                .description(apiDescription)
                .version(apiVersion)
                .build();
    }
}






