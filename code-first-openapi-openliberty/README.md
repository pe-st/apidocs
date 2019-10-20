# OpenAPI code-first approach with OpenLiberty

This directory contains a simple service implemented

- using the *code-first* approach to provide an OpenAPI document
- running with [OpenLiberty](https://openliberty.io/)'s
  MicroProfile [OpenAPI implementation](https://openliberty.io/guides/microprofile-openapi.html)

For more information consult the [README](../README.adoc) in the parent directory.

## How to run the service

Using OpenLiberty's [dev mode](https://openliberty.io/blog/2019/10/17/dev-mode-developer-experience.html):

    mvn liberty:dev

Once the service runs:

- http://localhost:8080/openapi fetches the OpenAPI document
- http://localhost:8080/openapi/ui shows an interactive view of the API (based on Swagger-UI)
