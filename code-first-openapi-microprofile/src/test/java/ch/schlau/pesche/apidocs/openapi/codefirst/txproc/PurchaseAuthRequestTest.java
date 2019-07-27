package ch.schlau.pesche.apidocs.openapi.codefirst.txproc;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.util.UUID;

import javax.ws.rs.core.MediaType;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import ch.schlau.pesche.apidocs.openapi.codefirst.txproc.model.EmvTags;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class PurchaseAuthRequestTest {

    @Test
    void purchase_ok() {
        // @formatter:off
        given()
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .body("{\"uuid\": \"aaaaaaaa-bbbb-cccc-dddd-012345678901\","
                     +" \"token\": \"42-token-abcdefg\","
                     +" \"emvTags\": { \"84\": \"MTI=\", \"9F1A\": \"AAI=\" } }")
        .when()
                .post("/api/txproc/purchase")
        .then()
                .statusCode(200)
                .body("result", is("OK"))
                .body("approvalCode", is("OK42"))
                ;
        // @formatter:off
    }

    @Test
    void json_roundtrip() throws IOException {

        // TODO convert this test to JSON-B
        ObjectMapper mapper = new ObjectMapper();

        PurchaseAuthRequest request = new PurchaseAuthRequest();
        request.setUuid(UUID.fromString("abcdabcd-1234-5678-aaaa-cccccccccccc"));
        request.setToken("42");
        var emvTags = new EmvTags();
        emvTags.setX84("ABC=");
        request.setEmvTags(emvTags);

        // JSON serialization
        String jsonString = mapper.writeValueAsString(request);
        assertThat(jsonString, is("{\"uuid\":\"abcdabcd-1234-5678-aaaa-cccccccccccc\",\"token\":\"42\",\"emvTags\":{\"x84\":\"ABC=\"}}"));

        // JSON deserialization
        PurchaseAuthRequest roundtrip = mapper.readerFor(PurchaseAuthRequest.class).readValue(jsonString);
        assertThat(roundtrip.getUuid().toString(), is("abcdabcd-1234-5678-aaaa-cccccccccccc"));
    }
}