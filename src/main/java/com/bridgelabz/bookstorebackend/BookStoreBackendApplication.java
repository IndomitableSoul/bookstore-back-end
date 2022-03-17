package com.bridgelabz.bookstorebackend;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.Collections;

@Slf4j
@SpringBootApplication
@EnableSwagger2
public class BookStoreBackendApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(BookStoreBackendApplication.class, args);
        log.info("BookStore Application started at {} Environment", applicationContext.getEnvironment().getProperty("environment"));
    }

    //ModelMapper Bean created
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    //PasswordEncoder Bean created
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //Docket Bean to do Swagger Configuration
    @Bean
    public Docket swaggerConfiguration(){
    //Return a prepared Docket instance
    return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .paths(PathSelectors.any())
            .apis(RequestHandlerSelectors.basePackage("com.bridgelabz.bookstorebackend"))
            .build()
            .apiInfo(apiMataData());
    }

    //Returns application metadata to swagger-ui
    public ApiInfo apiMataData(){
        return new ApiInfo(
                "BookStore API",
                "Free to use",
                "1.0",
                "",
                new springfox.documentation.service.Contact("Nikita Amar", "abc.com", "amaenikita09@gmail.com"),
                "API LICENCE",
                "amarnikita09@gmail.com",
                Collections.emptyList()
                );
      }
}
