package com.bridgelabz.bookstorebackend;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Slf4j
@SpringBootApplication
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


}
