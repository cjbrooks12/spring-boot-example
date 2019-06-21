package com.credera.completeexample;

import org.example.database.MySqlDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * A class with the @Configuration is needed because we need to tell Spring about the MySqlDatabase, which is "external"
 * to our project. Since we can't add Spring annotations to that class, we need to set up those mappings in this
 * Configuration class.
 */
@Configuration
public class AppConfig {

    /**
     * This method needed because MySqlDatabase is "external" to our application as we can't use the @Component
     * annotation on that class to tell Spring about it. Instead, we need to have a method with the @Bean annotation
     * which returns an instance of the the object we want to tell Spring about.
     *
     * In the same way, we cannot use @PostConstruct or @PreDestroy annotations within the MySqlDatabase class, so we
     * use the `initMethod` and `destroyMethod` properties of the annotation to tell Spring which methods to call on
     * those lifecycle hooks.
     *
     * We also annotate this one as @Primary so that it is chosen over the InMemoryDatabase anywhere a Database is
     * injected.
     */
    @Bean(initMethod = "connect", destroyMethod = "closeConnection")
    @Primary
    public MySqlDatabase mysqlDatabase() {
        return new MySqlDatabase();
    }

}
