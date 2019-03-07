package ch.schlau.pesche.apidocs.json_schema;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.json.JsonReader;
import javax.json.JsonValue;

import org.junit.jupiter.api.Test;
import org.leadpony.justify.api.JsonSchema;
import org.leadpony.justify.api.JsonValidationService;
import org.leadpony.justify.api.ProblemHandler;

class ValidationTest {

    @Test
    void parse_valid() throws URISyntaxException {

        JsonValidationService service = JsonValidationService.newInstance();

        // Reads the JSON schema
        JsonSchema schema = service.readSchema(Paths.get(getClass().getResource("/schema/pin-check-request.json").toURI()));

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

        JsonValidationService service = JsonValidationService.newInstance();

        JsonSchema schema = service.readSchema(Paths.get(getClass().getResource("/schema/pin-check-request.json").toURI()));

        // not sure if there are better ways to signal a problem
        ProblemHandler handler = service.createProblemPrinter(msg -> { throw new IllegalArgumentException(msg); });

        Path path = Paths.get(getClass().getResource("/invalid-request.json").toURI());

        try (JsonReader reader = service.createReader(path, schema, handler)) {
            assertThrows(IllegalArgumentException.class, reader::readValue);
        }
    }
}
