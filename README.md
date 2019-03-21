# API Docs

Examples of how a REST API can be documented with different technologies. 

## OpenAPI

Example using MicroProfile OpenAPI (note that there are small differences to the Swagger OpenAPI,
e.g. there is no `responses` in the MicroProfile `@Operation`)

Links:

- [MicroProfile OpenAPI Spec](https://github.com/eclipse/microprofile-open-api/blob/master/spec/src/main/asciidoc/microprofile-openapi-spec.adoc#operation)
    - [Annotation Examples](https://github.com/eclipse/microprofile-open-api/wiki/Annotation-Samples)
    - [YAML Output Examples](https://github.com/eclipse/microprofile-open-api/wiki/Static-File-Samples)
- [Swagger OpenAPI Spec](https://github.com/eclipse/microprofile-open-api/blob/master/spec/src/main/asciidoc/microprofile-openapi-spec.adoc)

Launch the example with OpenLiberty (`mvn install liberty:run-server`)
and browse the interface on http://localhost:8080/openapi/ui/

You can also use the [Swagger Online Editor](https://editor.swagger.io)
and open this URL:

- https://raw.githubusercontent.com/pe-st/apidocs/master/openapi-lombok/doc/openapi.yaml

Tradeoff: using the JsonXxxTypedef is a bit more cumbersome than just a String or Number property


## JSON Schema

Example schemas in [json-schema/src/main/resources/schema](tree/master/json-schema/src/main/resources/schema)

Links:

- Introduction: [Understanding JSON Schema](http://json-schema.org/understanding-json-schema/)
- Generate Java Code from JSON Schema: [jsonschema2pojo](https://github.com/joelittlejohn/jsonschema2pojo)

Remarks:

- OpenAPI Annotations are not supported out-of-the-box by jsonschema2pojo, but can easily
  be added with a custom annotator configured in the
  [maven plugin](https://joelittlejohn.github.io/jsonschema2pojo/site/1.0.0/generate-mojo.html)
- At the same time also other annotations like `@JsonIgnoreProperties(ignoreUnknown = true)` can be added


## Spring REST Docs

See [Spring REST Docs](spring-restdocs/README.md)
