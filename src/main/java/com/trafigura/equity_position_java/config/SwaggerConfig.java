package com.trafigura.equity_position_java.config;
import io.swagger.v3.oas.models.OpenAPI;
     import io.swagger.v3.oas.models.info.Info;
     import org.springframework.context.annotation.Bean;
     import org.springframework.context.annotation.Configuration;

     @Configuration
     public class SwaggerConfig {

         @Bean
         public OpenAPI openAPI() {
             return new OpenAPI()
                     .info(new Info()
                             .title("Equity Position's API")
                             .description("Your API Description")
                             .version("v1"));
         }
     }