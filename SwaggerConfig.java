package com.example.demo.components;


import com.example.demo.TestController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@PropertySource("classpath:swagger.properties")
@Component
public class SwaggerConfig {


    private static final String SWAGGER_API_VERSION = "1";

    private static final String LICENSE_TEXT = "License";

    private static final String title = "Produces Rest Api";

    private static final String description  = "Restful Api for products";

    private ApiInfo apiInfo(){

        return new ApiInfoBuilder()
                .title(title)
                .version(SWAGGER_API_VERSION)
                .description(description)
                .license(LICENSE_TEXT)
                .build();
    }

    @Bean
    public Docket producesTestApi (){

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .pathMapping("/")
                .select()
                .paths(PathSelectors.regex( "/*"))
                .build();


    }
}
