# OpenAPI design-first approach with Quarkus server and OpenAPI Generator

This directory contains a simple service implemented

- using the *design-first* approach to provide an OpenAPI document
- running with [Quarkus](https://quarkus.io/) server (providing the
  MicroProfile [OpenAPI](https://quarkus.io/guides/openapi-swaggerui-guide)
  endpoints), serving the static hand-written OpenAPI document that
  is also used to generate the POJOs of the service interface
- the POJOs are generated using [OpenAPI Generator](https://openapi-generator.tech/)'s
  Maven [plugin](https://github.com/OpenAPITools/openapi-generator/blob/master/modules/openapi-generator-maven-plugin/)

For more information consult the [README](../README.adoc) in the parent directory.

## How to run the service

Using Quarkus's [dev mode](https://quarkus.io/guides/maven-tooling.html#development-mode):

    mvn compile quarkus:dev

Once the service runs:

- http://localhost:8080/openapi fetches the OpenAPI document
- http://localhost:8080/swagger-ui shows an interactive view of the API (based on Swagger-UI)
