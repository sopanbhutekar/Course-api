package org.courseApi;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CourseApi {

	public static void main(String[] args) {
		SpringApplication.run(CourseApi.class,args);
	}
	
	@Bean
	public Docket configuringSwagger() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("org.courseApi"))
				.build()
				.apiInfo(getApiDetails());
	}

	private ApiInfo getApiDetails() {
		
		
		return new ApiInfo(
				"Course API",
				"Sample API for Spring Boot Practice",
				"1.0",
				"Free to Use",
				new springfox.documentation.service.Contact("Sopan Bhutekar", "sopanbhutekar.com", "abc@gmail.com"),
				"API License",
				"sopanbhutekar.com",
				Collections.emptyList());
	}

}
