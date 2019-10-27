package ch.schlau.pesche.apidocs.swagger.designfirst.rest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import javax.ws.rs.core.MediaType;

import org.junit.jupiter.api.Test;

class TxProcPurchaseIT {

    @Test
    void purchase_ok() {
        // @formatter:off
        given()
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .body("{\"uuid\": \"aaaaaaaa-bbbb-cccc-dddd-012345678901\","
                     +" \"pan\": \"4244333322221111\","
                     +" \"emvTags\": { \"84\": \"A0000000041010\", \"9f1A\": \"250\" } }")
        .when()
                .post("/api/txproc/purchase")
        .then()
                .statusCode(200)
                .body("result", is("OK"))
                .body("approvalCode", is("OK42.250"))
                ;
        // @formatter:off
    }
}