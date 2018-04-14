package com.alexandregsjr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by alexandreseverojr on 08/04/18.
 */
@SpringBootApplication
@ComponentScan({"com.alexandregsjr"})
@EnableMongoRepositories({"com.alexandregsjr"})
public class Application {

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }
}
