package ch.schlau.pesche.apidocs.swagger.designfirst;

import static com.fasterxml.jackson.dataformat.yaml.YAMLGenerator.Feature.MINIMIZE_QUOTES;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static net.javacrumbs.jsonunit.JsonMatchers.jsonEquals;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import lombok.Getter;
import lombok.Setter;

@QuarkusTest
class OpenapiDocumentIT {

    @Getter
    @Setter
    static class OpenapiSkeleton {
        String openapi;
        Object info;
        Object servers;
        Object paths;
        Object components;
        Object security;
        Object tags;
        Object externalDocs;
    }

    @Test
    void openapi_yaml() throws IOException {

        String expected = loadResourceFile("openapi.yaml");
        String expectedSorted = loadResourceFile("openapi-sorted.yaml");

        String document = when().get("/openapi")
                .then()
                .statusCode(200)
                .extract().response().asString();

        String yamlSorted = sortYaml(document);

        assertAll("openapi yaml"
                , () -> assertThat("unsorted", document, is(expected))
                , () -> assertThat("sorted", yamlSorted, is(expectedSorted))
        );
    }

    @Test
    void openapi_json() throws IOException {

        String expected = loadResourceFile("openapi.json");

        String document = given().accept(ContentType.JSON)
                .when().get("/openapi")
                .then()
                .statusCode(200)
                .extract().response().asString();

        assertThat(document, jsonEquals(expected));
    }

    private String sortYaml(String yaml) throws IOException {
        ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory().enable(MINIMIZE_QUOTES));
        OpenapiSkeleton objFromYaml = yamlMapper.readValue(yaml, OpenapiSkeleton.class);

        ObjectMapper jsonMapper = new ObjectMapper()
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
        String jsonSorted = jsonMapper.writeValueAsString(objFromYaml);
        Object objFromJson = jsonMapper.readValue(jsonSorted, Object.class);

        return yamlMapper.writeValueAsString(objFromJson);
    }

    private String loadResourceFile(String s) throws IOException {
        return IOUtils.toString(getClass().getClassLoader().getResourceAsStream(s), StandardCharsets.UTF_8)
                // needed on Windows depending on the Git configuration (core.autocrlf)
                .replace("\r\n", "\n");
    }
}
