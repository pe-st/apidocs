package ch.schlau.pesche.apidocs.openapi.codefirst;

import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class OpenapiDocumentTest {

    @Test
    void openapi_yaml() throws IOException {

        String expected = IOUtils.toString(getClass().getClassLoader().getResourceAsStream("openapi.yaml"), "UTF-8");

        String document = when().get("/openapi")
                .then()
                .statusCode(200)
                .extract().response().asString();

        assertThat(document, is(expected));
    }
}
