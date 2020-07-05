package br.com.glassroom.configuration.infrastructure;

import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableSwagger2
public class SwaggerConfig {

//	private static final String BASE_PACKAGE = "br.com.glassroom.entrypoint";
//
//	@Bean
//	public Docket api() {
//		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
//				.paths(PathSelectors.any()).build()
//				// .globalResponseMessage(RequestMethod.GET, listResponseMessage())
//				.apiInfo(metaData());
//	}
//
//	@SuppressWarnings("unused")
//	private List<ResponseMessage> listResponseMessage() {
//		List<ResponseMessage> listResponse = new ArrayList<>();
//
//		listResponse.add(new ResponseMessageBuilder().code(HttpStatus.OK.value()).message("").build());
//		listResponse.add(new ResponseMessageBuilder().code(HttpStatus.SERVICE_UNAVAILABLE.value())
//				.message("Service Unavailable").build());
//
//		return listResponse;
//	}
//
//	private ApiInfo metaData() {
//		return new ApiInfoBuilder().title("GlassRoom API").description("Documentação da API").version("1.0.0")
//				.license("Apache Licence Version 2.0").build();
//	}

}
