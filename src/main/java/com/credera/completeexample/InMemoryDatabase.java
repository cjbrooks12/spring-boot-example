package com.credera.completeexample;

import org.example.database.Database;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * This String allows us to the the @Qualifier annotation with a matching String to inject an instance of this class,
 * instead of the real MySqlDatabase.
 */
@Component("InMemoryDatabase")
public class InMemoryDatabase implements Database {

    @Override
    public String getUserByName(String name) {
        switch (name) {
            case "harry": return "Harry (mock)";
            case "ron": return "Ron (mock)";
            case "hermione": return "Hermione (mock)";
            default: throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found: " + name);
        }
    }

    /**
     * Since this class has the @Component annotation, we can use @PostConstruct on this method directly
     */
    @PostConstruct
    public void connect() {
        System.out.println("No need to connect to in-memory database");
    }

    /**
     * Since this class has the @Component annotation, we can use @PreDestroy on this method directly
     */
    @PreDestroy
    public void closeConnection() {
        System.out.println("No need to close connection to in-memory database");
    }
}
