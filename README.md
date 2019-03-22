# API Docs

Examples of how a REST API can be documented with different technologies.

Goals are:
- have a detailed documentation (e.g. not limited to a one-line string per field)
- don't duplicate the documentation if the same field is used for different endpoints
- appropriate documentation in the IDE (i.e. Javadoc, for programming the server and the clients)
  as well as in tools like the Swagger Editor

The examples use OpenLiberty as server just because it not only supports MicroProfile OpenAPI,
but it comes also with an integrated UI. But the examples should run without any code changes
in any MicroProfile compatible server.

## OpenAPI

Example using OpenAPI 3 (The MicroProfile implementation, though Swagger would need almost no changes;
there are only small differences to the Swagger OpenAPI, e.g. there is no `responses` in the MicroProfile `@Operation`
or `@APIResponse` with MicroProfile vs. `@ApiResponse` with Swagger)

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

Tradeoffs:

- using subclasses of `JsonXxxTypedef` is a bit more cumbersome than just a String or Number property
- no way to have the same information in Javadoc and in OpenAPI without duplication and double maintenance


## JSON Schema

Example schemas in [json-schema/src/main/resources/schema](tree/master/json-schema/src/main/resources/schema)

Links:

- Introduction: [Understanding JSON Schema](http://json-schema.org/understanding-json-schema/)
- Generate Java Code from JSON Schema: [jsonschema2pojo](https://github.com/joelittlejohn/jsonschema2pojo)

Tradeoffs:

- Longer documentation (multiline) is cumbersome (all on one line with `\n` or `<p>` separating the lines),
  though workarounds with proprietary keys in the schema are easily programmed (see `"model.json#/token"`
  and the `schema2pojo` submodule).

Remarks:

- OpenAPI Annotations are not supported out-of-the-box by jsonschema2pojo, but can easily
  be added with a custom annotator configured in the
  [maven plugin](https://joelittlejohn.github.io/jsonschema2pojo/site/1.0.0/generate-mojo.html)
- At the same time also other annotations like `@JsonIgnoreProperties(ignoreUnknown = true)` can be added


## Spring REST Docs

Work in progress, see [Spring REST Docs](spring-restdocs/README.md)
