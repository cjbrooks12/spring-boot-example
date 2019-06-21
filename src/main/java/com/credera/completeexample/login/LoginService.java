package com.credera.completeexample.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * The job of a Service is to manage the "business logic" around fetching data, such as caching expensive database
 * queries. On a cache miss, it just delegates to UsersRepository, which actually runs the databse query.
 */
@Service // @Service is the same as @Component
public class LoginService {

    @Autowired
    private UsersRepository repository;

    private Map<String, String> usersCache = new HashMap<>();

    public String getUserByName(String name, boolean mock) {

        // if we've queried this before, return the result from the cache. Don't use the cache when making a mock query
        if(!mock && usersCache.containsKey(name)) {
            System.out.println("returning " + name + " from cache");
            return usersCache.get(name);
        }

        // otherwise, run the query and cache the result for later
        else {
            System.out.println("querying for " + name);
            String user = repository.getUserByName(name, mock);
            usersCache.put(name, user);
            return user;
        }
    }

}
