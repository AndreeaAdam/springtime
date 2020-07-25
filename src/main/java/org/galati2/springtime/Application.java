package org.galati2.springtime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "org.galati2.springtime")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

}
