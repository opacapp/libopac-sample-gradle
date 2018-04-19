# opacapi

A web API wrapper for the [opacclient][opacclient-github] library based on [Spring Boot][spring-boot-website].

## Usage

    $ ./gradlew run

This has to be uploaded on the same level in the files system
    https://github.com/opacapp/opacapp-config-files.git

This starts the Spring Boot application.

A list of all libraries is returned here:

    http://localhost:8080/libraries

The search fields for a library can be found at:

    http://localhost:8080/library/{libraryName}/searchFields


[opacclient-github]: https://github.com/opacapp/opacclient
[spring-boot-website]: https://projects.spring.io/spring-boot/

## Vision

The initial idea for this project was born when @k-nut discovered [libraryextension](https://www.libraryextension.com). Libraryextension is a browser extension which tells you when you are browsing for book on Amazon or another bookseller if the book you are currently looking at is also avaialbe in your public library. Unfortunately the extension does not support very many libraries in Germany yet. The good thing is that there is an existing Android project called [Web Opac App](https://github.com/opacapp/opacclient) which allows users to browse more then 1000 public libraries in Germany. So the idea of this project was born: Bring the libraryextension and the libopac (which powers the Web Opac App) together to add support for tons of German libraries to the extension.

The idea was to do this by providing a centralised Web-API as an interface to all public libraries in Germany. That way the developers of libraryextension only need to add one new data provider to get tons of new libraries into their extension.

### MVP

This means that the MVP of this application is actually quite small in scope: As users want to select their local library the API should provide data per library. The only question that we really want to answer is: Does my public library have the book with the ISBN I am currenlty looking at - and if yes how many copies are available right now. 

It also means that we a are probably good with two endpoints: 

- [ ] An endpoint where people can get a list of libraries and select the one closest to them 
- [ ] An endpoint where we can find the availaiblity status of a book given its ISBN for their library of choice

