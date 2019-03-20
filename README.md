# API Docs

Examples of how a REST API can be documented with different technologies. 

## OpenAPI

Example using MicroProfile OpenAPI (note that there are small differences to the Swagger OpenAPI,
e.g. there is no `responses` in the MicroProfile `@Operation`)

- Examples with and without Lombok
- The Lombok one is more detailed (because there's less boilerplate to write)

Links:

- [MicroProfile OpenAPI Spec](https://github.com/eclipse/microprofile-open-api/blob/master/spec/src/main/asciidoc/microprofile-openapi-spec.adoc#operation)
    - [Annotation Examples](https://github.com/eclipse/microprofile-open-api/wiki/Annotation-Samples)
    - [YAML Output Examples](https://github.com/eclipse/microprofile-open-api/wiki/Static-File-Samples)
- [Swagger OpenAPI Spec](https://github.com/eclipse/microprofile-open-api/blob/master/spec/src/main/asciidoc/microprofile-openapi-spec.adoc)

Launch the example with OpenLiberty (`mvn install liberty:run-server`)
and browse the interface on http://localhost:8080/openapi/ui/

You can also use the [Swagger Online Editor](https://editor.swagger.io)
and open these URLs:

- https://raw.githubusercontent.com/pe-st/apidocs/master/openapi/doc/openapi.yaml
- https://raw.githubusercontent.com/pe-st/apidocs/master/openapi-lombok/doc/openapi.yaml


## JSON Schema

Example schemas in [json-schema/src/main/resources/schema](tree/master/json-schema/src/main/resources/schema)

IMHO less duplication, it's easier to extract out the definition of a type used by several endpoints


## Spring REST Docs

See [Spring REST Docs](spring-restdocs/README.md)
