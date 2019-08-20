package ch.schlau.pesche.apidocs.openapi.codefirst;

import static com.fasterxml.jackson.dataformat.yaml.YAMLGenerator.Feature.MINIMIZE_QUOTES;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import io.quarkus.test.junit.QuarkusTest;
import lombok.Getter;
import lombok.Setter;

@QuarkusTest
class OpenapiDocumentTest {

    @Getter
    @Setter
    static class OpenapiSkeleton {
        String openapi;
        Object info;
        Object server;
        Object paths;
        Object components;
        Object security;
        Object tags;
        Object externalDocs;
    }

    @Test
    void openapi_yaml() throws IOException {

        String expected = IOUtils.toString(getClass().getClassLoader().getResourceAsStream("openapi.yaml"), "UTF-8")
                // needed on Windows depending on the Git configuration (core.autocrlf)
                .replace("\r\n", "\n");
        String expectedSorted = IOUtils.toString(getClass().getClassLoader().getResourceAsStream("openapi-sorted.yaml"), "UTF-8")
                // needed on Windows depending on the Git configuration (core.autocrlf)
                .replace("\r\n", "\n");

        String document = when().get("/openapi")
                .then()
                .statusCode(200)
                .extract().response().asString();

        assertThat("unsorted", document, is(expected));

        String yamlSorted = sortYaml(document);
        assertThat("sorted", yamlSorted, is(expectedSorted));
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
}
