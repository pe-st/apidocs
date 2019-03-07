# API Docs

Examples of how a REST API can be documented with different technologies. 

## OpenAPI

Example using MicroProfile OpenAPI (note that there are small differences to the Swagger OpenAPI,
e.g. there is no `responses` in the MicroProfile `@Operation`)

- [MicroProfile OpenAPI Spec](https://github.com/eclipse/microprofile-open-api/blob/master/spec/src/main/asciidoc/microprofile-openapi-spec.adoc#operation)
    - [Annotation Examples](https://github.com/eclipse/microprofile-open-api/wiki/Annotation-Samples)
    - [YAML Output Examples](https://github.com/eclipse/microprofile-open-api/wiki/Static-File-Samples)
- [Swagger OpenAPI Spec](https://github.com/eclipse/microprofile-open-api/blob/master/spec/src/main/asciidoc/microprofile-openapi-spec.adoc)

Launch the example with OpenLiberty (`mvn install liberty:start-server`)
and browse the interface on http://localhost:8080/openapi/ui/

You can also use the [Swagger Online Editor](https://editor.swagger.io)
and open this URL: https://raw.githubusercontent.com/pe-st/apidocs/master/openapi/doc/openapi.yaml


## Spring REST Docs

See [Spring REST Docs](spring-restdocs/README.md)
