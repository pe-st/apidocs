package ch.schlau.pesche.apidocs.json_schema;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.json.JsonReader;
import javax.json.JsonValue;

import org.junit.jupiter.api.Test;
import org.leadpony.justify.api.JsonSchema;
import org.leadpony.justify.api.JsonSchemaReader;
import org.leadpony.justify.api.JsonSchemaReaderFactory;
import org.leadpony.justify.api.JsonSchemaResolver;
import org.leadpony.justify.api.JsonValidationService;
import org.leadpony.justify.api.ProblemHandler;

class ValidationTest {

    private final JsonValidationService service = JsonValidationService.newInstance();

    @Test
    void parse_valid() throws URISyntaxException {

        // Reads the JSON schema
        JsonSchema schema = readSchema(Paths.get(getClass().getResource("/schema/pin-check-request.json").toURI()));

        // Problem handler which will print problems found.
        ProblemHandler handler = service.createProblemPrinter(System.out::println);

        Path path = Paths.get(getClass().getResource("/valid-request.json").toURI());

        try (JsonReader reader = service.createReader(path, schema, handler)) {
            JsonValue value = reader.readValue();
            // Do something useful here
        }
    }

    @Test
    void parse_invalid() throws URISyntaxException {

        JsonSchema schema = readSchema(Paths.get(getClass().getResource("/schema/pin-check-request.json").toURI()));

        // not sure if there are better ways to signal a problem
        ProblemHandler handler = service.createProblemPrinter(msg -> { throw new IllegalArgumentException(msg); });

        Path path = Paths.get(getClass().getResource("/invalid-request.json").toURI());

        try (JsonReader reader = service.createReader(path, schema, handler)) {
            assertThrows(IllegalArgumentException.class, reader::readValue);
        }
    }

    private JsonSchema readSchema(Path path) {
        JsonSchemaReaderFactory factory = service.createSchemaReaderFactoryBuilder()
                .withSchemaResolver(new ResourcesJsonSchemaResolver()).build();
        try (JsonSchemaReader reader = factory.createSchemaReader(path)) {
            return reader.read();
        }
    }

    /**
     * Schema resolver which will provide schemas from the resources.
     */
    private class ResourcesJsonSchemaResolver implements JsonSchemaResolver {

        @Override
        public JsonSchema resolveSchema(URI id) {
            try {
                Path path = Paths.get(getClass().getResource("/schema/" + id.getPath()).toURI());
                return service.readSchema(path);
            } catch (URISyntaxException e) {
                return null;
            }
        }
    }
}
