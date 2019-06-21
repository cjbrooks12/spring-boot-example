package com.credera.completeexample;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The @SpringBootApplication annotation tells Spring this is the root for our whole application. By default, only the
 * classes in the `com.credera.completeexample` package will be scanned (meaning the classes in `org.example.database`
 * will not be scanned). We'll have to manually tell Spring about those classes.
 */
@SpringBootApplication
public class CompleteExampleApplication implements CommandLineRunner {

    public static void main(String[] args) {
        // Run the application
        //   - beans are created
        //   - @PostConstruct and @Bean(initMethod="") methods get run
        //   - run() method below gets called
        SpringApplication.run(CompleteExampleApplication.class, args);
        // @PreDestroy and @Bean(destroyMethod="") methods get run
    }

    @Override
    public void run(String... args) throws Exception {
        // Do something inside our application

        // The "pre-destroy" callbacks we told Spring about will not be run until this method returns
    }
}
