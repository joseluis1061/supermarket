package com.jlzdev.supermarket.web.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SwaggerConfig {
  public static void main(String[] arg){
    SpringApplication.run(SwaggerConfig.class);
  }
  @Bean
  public OpenAPI customOpenApi(){
    return new OpenAPI()
        .info(new Info()
            .title("Supermarket API")
            .version("0.1")
            .description("Supermarket inventory and products purchases")
            .termsOfService("https://www.linkedin.com/in/joseluis-zuniga/")
            .license(new License().name("Apache 2.0").url("http://springdoc.org"))
        );
  }

}


