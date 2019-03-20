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

Tradeoff: using the JsonXxxTypedef is a bit more cumbersome than just a String or Number property


## JSON Schema

Example schemas in [json-schema/src/main/resources/schema](tree/master/json-schema/src/main/resources/schema)

IMHO less duplication, it's easier to extract out the definition of a type used by several endpoints

Tradeoff: The generated classes are fine for usage in the IDE, but don't have OpenAPI annotations

- OpenAPI Annotations can probably be added by a custom annotator, see `<customAnnotator>` and `<customRuleFactory>`
  ([maven plugin](https://joelittlejohn.github.io/jsonschema2pojo/site/1.0.0/generate-mojo.html))
- At the same time also the `@JsonIgnoreProperties(ignoreUnknown = true)` should be added


## Spring REST Docs

See [Spring REST Docs](spring-restdocs/README.md)
