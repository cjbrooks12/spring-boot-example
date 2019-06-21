package com.credera.completeexample.login;

import org.example.database.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * The UsersRepository is reponsible for talking directly to the Database to fetch data. Think of the Database interface
 * as part of an external library that we use to talk to the databse.
 *
 * We also support running "mock" queries, which are run on an in-memory database instead of the real database. This is
 * useful for testing.
 */
@Repository // @Repository is the same as @Component
public class UsersRepository {

    /**
     * We want Spring to inject the real database to this field. MySqlDatabase is what will be chosen to inject, since
     * the @Bean method in AppConfig which return MySqlDatabase is annotated with @Primary
     */
    @Autowired
    private Database realDatabase;

    /**
     * We want to inject the InMemoryDatabase to this field. We can't do it without a qualifier, since injecting an
     * instance of Database without a qualifier would provide a MySqlDatabase, since that's what it's doing in the field
     * above. But if we use @Qualifier with a String that matches the String that was also put in @Component on our
     * InMemoryDatabase class, we can get an instance of InMemoryDatabase injected here.
     */
    @Autowired
    @Qualifier("InMemoryDatabase") // this String matches what's on InMemoryDatabase's @Component
    private Database mockDatabase;

    public String getUserByName(String name, boolean mock) {
        if(mock) {
            return mockDatabase.getUserByName(name);
        }
        else {
            return realDatabase.getUserByName(name);
        }
    }

}
