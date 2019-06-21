package org.example.database;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class MySqlDatabase implements Database {

    @Override
    public String getUserByName(String name) {
        delay();
        switch (name) {
            case "harry": return "Harry";
            case "ron": return "Rom";
            case "hermione": return "Hermione";
            default: throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found: " + name);
        }
    }

    /**
     * This method will be called because AppConfig has an @Bean-annotated method which returns this object and
     * specifies @Bean(initMethod = "connect")
     */
    public void connect() {
        System.out.println("Connecting to mysql database...");
        delay();
        System.out.println("Done connecting to mysql database...");
    }

    /**
     * This method will be called because AppConfig has an @Bean-annotated method which returns this object and
     * specifies @Bean(destroyMethod = "closeConnection")
     */
    public void closeConnection() {
        System.out.println("Closing connection to mysql database...");
        delay();
        System.out.println("Done closing connection to mysql database...");
    }

    // simulates the delay caused by running an actual database query
    private void delay() {
        try {
            Thread.sleep(1500);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
