package ch.schlau.pesche.apidocs.swagger.designfirst.rest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import jakarta.ws.rs.core.MediaType;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class TxProcPincheckIT {

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
}