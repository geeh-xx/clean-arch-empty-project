package br.com.glassroom.configuration.infrastructure;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private static final String BASE_PACKAGE = "br.com.glassroom.entrypoint";
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
						.select()
						.apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
						.paths(PathSelectors.any())
						.build()
						//.globalResponseMessage(RequestMethod.GET, listResponseMessage())
						.apiInfo(metaData());
	}
	
	private List<ResponseMessage> listResponseMessage(){
		List<ResponseMessage> listResponse = new ArrayList<>();
		
		listResponse.add(new ResponseMessageBuilder().code(HttpStatus.OK.value()).message("").build());
		listResponse.add(new ResponseMessageBuilder().code(HttpStatus.SERVICE_UNAVAILABLE.value()).message("Service Unavailable").build());

		return listResponse;
	}
	
	private ApiInfo metaData() {
		return new ApiInfoBuilder().title("GlassRoom API")
								   .description("Documentação da API")
								   .version("1.0.0")
								   .license("Apache Licence Version 2.0")
								   .build();
	}
	
}
