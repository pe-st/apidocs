# API Docs

Examples of how a REST API can be documented with different technologies. 

## OpenAPI

Example using MicroProfile OpenAPI (note that there are small differences to the Swagger OpenAPI,
e.g. there is no `responses` in the MicroProfile `@Operation`)

- [MicroProfile OpenAPI Spec](https://github.com/eclipse/microprofile-open-api/blob/master/spec/src/main/asciidoc/microprofile-openapi-spec.adoc#operation)
- [Swagger OpenAPI Spec](https://github.com/eclipse/microprofile-open-api/blob/master/spec/src/main/asciidoc/microprofile-openapi-spec.adoc)

Launch the example with OpenLiberty (`mvn install liberty:start-server`)
and browse the interface on http://localhost:8080/openapi/ui/


## Spring REST Docs

See [Spring REST Docs](spring-restdocs/README.md)
