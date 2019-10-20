# OpenAPI code-first approach with Quarkus

This directory contains a simple service implemented

- using the *code-first* approach to provide an OpenAPI document
- running with [Quarkus](https://quarkus.io/)'
  MicroProfile [OpenAPI implementation](https://quarkus.io/guides/openapi-swaggerui-guide)

For more information consult the [README](../README.adoc) in the parent directory.

## How to run the service

Using Quarkus's [dev mode](https://quarkus.io/guides/maven-tooling.html#development-mode):

    mvn compile quarkus:dev

Once the service runs:

- http://localhost:8080/openapi fetches the OpenAPI document
- http://localhost:8080/swagger-ui shows an interactive view of the API (based on Swagger-UI)
