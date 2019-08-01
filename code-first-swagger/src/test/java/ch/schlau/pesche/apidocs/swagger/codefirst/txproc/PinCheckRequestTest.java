package ch.schlau.pesche.apidocs.swagger.codefirst.txproc;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;

import javax.ws.rs.core.MediaType;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class PinCheckRequestTest {

    @Test
    void pincheck_ok() {
        // @formatter:off
        given()
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .body("{\"uuid\": \"aaaaaaaa-bbbb-cccc-dddd-012345678901\", \"pinBlock\": \"magic\"}")
        .when()
                .post("/api/txproc/pincheck")
        .then()
                .statusCode(200)
                .body("result", is("OK"))
                .body("tries", is(3))
                ;
        // @formatter:off
    }

    @Test
    void json_roundtrip() throws IOException {

        // TODO convert this test to JSON-B
        ObjectMapper mapper = new ObjectMapper();

        PinCheckRequest request = new PinCheckRequest();
        request.setUuid("abcd-1234");

        // JSON serialization
        String jsonString = mapper.writeValueAsString(request);
        assertThat(jsonString, is("{\"uuid\":\"abcd-1234\",\"pinBlock\":null}"));

        // JSON deserialization
        PinCheckRequest roundtrip = mapper.readerFor(PinCheckRequest.class).readValue(jsonString);
        assertThat(roundtrip.getUuid(), is("abcd-1234"));
    }
}