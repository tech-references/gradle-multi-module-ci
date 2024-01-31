package me.bigfanoftim.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"me.bigfanoftim.core"})
@EnableJpaRepositories(basePackages = {"me.bigfanoftim.core"})
@ComponentScan(basePackages = {"me.bigfanoftim.api", "me.bigfanoftim.core"})
@SpringBootApplication
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}
