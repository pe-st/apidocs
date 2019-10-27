# OpenAPI design-first approach with OpenLiberty server and Swagger Codegen

This directory contains a simple service implemented

- using the *design-first* approach to provide an OpenAPI document
- running with [OpenLiberty](https://openliberty.io/) server (providing the
  MicroProfile [OpenAPI](https://openliberty.io/guides/microprofile-openapi.html)
  endpoints), serving the static hand-written OpenAPI document that
  is also used to generate the POJOs of the service interface
- the POJOs are generated using [Swagger Codegen](https://swagger.io/tools/swagger-codegen/)'s
  Maven [plugin](https://github.com/swagger-api/swagger-codegen/tree/3.0.0/modules/swagger-codegen-maven-plugin)

For more information consult the [README](../README.adoc) in the parent directory.

## How to run the service

Using OpenLiberty's [dev mode](https://openliberty.io/blog/2019/10/17/dev-mode-developer-experience.html):

    mvn liberty:dev

Once the service runs:

- http://localhost:8080/openapi fetches the OpenAPI document
- http://localhost:8080/openapi/ui shows an interactive view of the API (based on Swagger-UI)
