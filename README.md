# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

## Spring Quick Reference

| Annotation | Where it Goes | What It's For |
| --- | --- | --- |
| `@Configuration` | a configuration Class | Methods annotated with `@Bean` inside this class tell Spring about beans |
| `@Bean` | methods inside the `@Configuration` class| Contribute a single bean to Spring that does not have any `@Component` annotations |
| `@Component` | a "bean" Class | Spring will automatically detect this class as a bean during Component Scanning |
| `@Service` | a "bean" Class | Same thing as `@Component` |
| `@Repository` | a "bean" Class | Same thing as `@Component` |
| `@PostConstruct` | a method inside a bean class | Spring will automatically call this method after a bean has been created. Same thing as `@Bean(initMethod="...")` |
| `@PreDestroy` | a method inside a bean class | Spring will automatically call this method as the application is shutting down. Same thing as `@Bean(destroyMethod="...")` |
| `@Autowired` | a field inside a bean class | Request that Spring inject a dependency into this field |
| `@Qualifier` | a field annotated with `@Autowired` | When two beans could be injected into this field, the Qualifier name chooses just one of those to inject |
| `@Primary` | a class annotated with `@Component`, or a method annotated with `@Bean` | When two beans could be injected into an `@Autowired` field, `@Primary` decides which one is chosen to inject |

## Git Quick Reference

### Upload your local changes to Github

1. `git add -A` - Tells Git you want to upload all your changed files
1. `git commit -m "<commit message>"` - Create a commit in your local repository. It contains all the changes added in
    the previous step.
1. `git push origin master` - Push your recently-created commit to your remote Github repository. 
