package ru.itpark.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages = "ru.itpark")
@EntityScan(basePackages = "ru.itpark.models")
@EnableJpaRepositories(basePackages = "ru.itpark.repositories")
public class Program {
    public static void main(String[] args) throws Exception {
            SpringApplication.run(Program.class);
    }
}