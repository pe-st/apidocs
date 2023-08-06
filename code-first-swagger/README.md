# OpenAPI code-first approach with Quarkus server and Swagger scanner

This directory contains a simple service implemented

- using the *code-first* approach to provide an OpenAPI document
- running with [Quarkus](https://quarkus.io/) server (providing the
  MicroProfile [OpenAPI](https://quarkus.io/guides/openapi-swaggerui-guide)
  endpoints, serving a static OpenAPI document created with the Swagger
  [scanner maven plugin](https://github.com/swagger-api/swagger-core/tree/master/modules/swagger-maven-plugin))

For more information consult the [README](../README.adoc) in the parent directory.

## How to run the service

Using Quarkus's [dev mode](https://quarkus.io/guides/maven-tooling.html#development-mode):

    mvn compile quarkus:dev

Once the service runs:

- http://localhost:8080/openapi fetches the OpenAPI document
- http://localhost:8080/swagger-ui shows an interactive view of the API (based on Swagger-UI)

## Swagger Scanner

Plugin source: [swagger-maven-plugin](https://github.com/swagger-api/swagger-core/tree/master/modules/swagger-maven-plugin)
