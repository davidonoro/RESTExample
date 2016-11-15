package com.david.springboot.items;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by ddor on 14/11/2016.
 * UI del swagger ==> http://localhost:5050/swagger-ui.html
 * Json descriptor del swagger ==> http://localhost:5050/v2/api-docs?group=items
 */
@SpringBootApplication
@EnableSwagger2
@ComponentScan("com.david.springboot.items")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * Configuracion del documento
     * @return
     */
    @Bean
    public Docket newsApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("items")
                .apiInfo(getApiInfo())
                .select()
                .paths(regex("/items.*"))
                .build();
    }

    /**
     * Info del api
     * @return
     */
    private ApiInfo getApiInfo(){
        return new ApiInfoBuilder()
                .title("Items Swagger")
                .description("Swagger para mi ejemplo del API REST con items")
                .termsOfServiceUrl("https://www.google.es/intl/es/policies/terms/regional.html")
                .contact("david.onoro@gmail.com")
                .license("Mi licencia")
                .licenseUrl("https://www.google.es/intl/es/policies/terms/regional.html")
                .version("1.0.0")
                .build();
    }
}
