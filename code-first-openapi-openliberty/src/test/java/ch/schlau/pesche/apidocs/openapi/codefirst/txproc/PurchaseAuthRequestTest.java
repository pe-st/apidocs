package ch.schlau.pesche.apidocs.openapi.codefirst.txproc;

import static ch.schlau.pesche.apidocs.openapi.codefirst.rest.JsonConfiguration.JSONB;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.UUID;

import javax.ws.rs.core.MediaType;

import org.junit.jupiter.api.Test;

import ch.schlau.pesche.apidocs.openapi.codefirst.txproc.model.EmvTags;
import ch.schlau.pesche.apidocs.openapi.codefirst.txproc.model.Pan;

class PurchaseAuthRequestTest {

    @Test
    void purchase_ok() {
        // @formatter:off
        given()
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .body("{\"uuid\": \"aaaaaaaa-bbbb-cccc-dddd-012345678901\","
                     +" \"pan\": \"4244333322221111\","
                     +" \"emvTags\": { \"84\": \"A0000000041010\", \"x9F1A\": \"250\" } }")
        .when()
                .post("/api/txproc/purchase")
        .then()
                .statusCode(200)
                .body("result", is("OK"))
                .body("approvalCode", is("OK42.250"))
                ;
        // @formatter:off
    }

    @Test
    void json_roundtrip() {

        PurchaseAuthRequest request = new PurchaseAuthRequest();
        request.setUuid(UUID.fromString("abcdabcd-1234-5678-aaaa-cccccccccccc"));
        request.setPan(new Pan("42"));
        var emvTags = new EmvTags();
        emvTags.setX84("A0000000041010");
        request.setEmvTags(emvTags);

        // JSON serialization
        String jsonString = JSONB.toJson(request);
        assertThat(jsonString, is("{\"emvTags\":{\"84\":\"A0000000041010\"},\"pan\":\"42\",\"uuid\":\"abcdabcd-1234-5678-aaaa-cccccccccccc\"}"));

        // JSON deserialization
        PurchaseAuthRequest roundtrip = JSONB.fromJson(jsonString, PurchaseAuthRequest.class);
        assertThat(roundtrip.getUuid().toString(), is("abcdabcd-1234-5678-aaaa-cccccccccccc"));
    }
}