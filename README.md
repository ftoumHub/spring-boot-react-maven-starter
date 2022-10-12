spring-boot-react-maven-starter
-----

This is a multi-module Spring Boot React Apache Maven starter app with good defaults.<br>
The react app is built using [create-react-app](https://github.com/facebookincubator/create-react-app).

This project provides a productive setup for building Spring Boot React applications.<br>
The application is divided into two Maven modules:

1. `api`: This contains Java code of the application.
2. `ui` : This contains all react JavaScript code of the application.

## Running the full application

You can build the package as a single artifact by running the `mvn clean install`.
Next, you can run the application by executing:

```bash
$ java -jar api/target/spring-boot-react-starter-api.jar
```

The application will be accessible at `http://localhost:3500`.

The products api will be accessible at `http://localhost:3500/api/products`.

## Features

This starter comes bundled with the following features:

1. Multi module Maven project: A multi module project to modularize backend and frontend code separately.
2. Maven wrapper: So, you don't need to install Maven on your machine.
3. Checkstyle: Enforce sane coding standard guidelines.
4. CORS enabled: A global configuration is added to enable CORS so that frontend can work seamlessly with backend during development.

## Running the backend for development mode

There are multiple ways to run the backend. For development, you can use your favorite IDE and run the
`com.xebia.starter.Application`. As soon as your code compiles, Spring Boot DevTools will reload the code.

You can also run the application using Maven.

```bash
$ cd api
$ mvn spring-boot:run
```

## Running the frontend for development mode

**You will need Node 12+ and npm to run the dev server and build the project**.


```
$ cd ui
$ npm start
```

## Docker Setup

To build the docker images and start the containers using Docker Compose run the following command. 
This will work in the *nix systems.

```
$ sh docker.sh
```

You can view running docker containers by executing following command.

```
$ docker ps
``` 

To stop and remove all docker container you have to run following command. 
This command should be run from project root.

```
$ docker-compose stop && docker-compose rm --force
``` 