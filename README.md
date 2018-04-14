# opacapi

A web API wrapper for the [opacclient][opacclient-github] library based on [Spring Boot][spring-boot-website].


## Usage

    $ ./gradlew run

This starts the Spring Boot application.

A list of all libraries is returned here:

    http://localhost:8080/libraries

The search fields for a library can be found at:

    http://localhost:8080/library/{libraryName}/searchFields


[opacclient-github]: https://github.com/opacapp/opacclient
[spring-boot-website]: https://projects.spring.io/spring-boot/
