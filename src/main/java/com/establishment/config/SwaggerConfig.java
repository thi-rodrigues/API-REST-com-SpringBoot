package com.establishment.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.establishment"))
				.paths(regex("/clientes.*"))
				.build()
				.apiInfo(metaInfo());
	}

	private ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfo(
				"Estabelecimento API REST", 
				"API REST de Estabelecimento.", 
				"1.0",
				"Terms of Service",
				new Contact("Thiago Rodrigues", "https://www.linkedin.com/in/thiago-rodrigues-171a4315a/", 
						"thiagorodrigues1203@outlook.com"),
				"Apache License, Version 2.0", 
				"https://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>()
				
		);

		return apiInfo;
	}
}
