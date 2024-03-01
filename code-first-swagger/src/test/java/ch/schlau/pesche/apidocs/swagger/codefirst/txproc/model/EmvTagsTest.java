package ch.schlau.pesche.apidocs.swagger.codefirst.txproc.model;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import jakarta.json.bind.Jsonb;

import org.junit.jupiter.api.Test;

import ch.schlau.pesche.apidocs.swagger.codefirst.rest.JsonConfiguration;

class EmvTagsTest {

    @Test
    void json_roundtrip() {

        Jsonb jsonb = JsonConfiguration.createJsonb();

        EmvTags emv = new EmvTags();
        emv.setX84("A0000000043060");

        // JSON serialization
        String jsonString = jsonb.toJson(emv);
        assertThat(jsonString, is("{\"84\":\"A0000000043060\"}"));

        // JSON deserialization
        EmvTags roundtrip = jsonb.fromJson(jsonString, EmvTags.class);
        assertThat(roundtrip.getX84(), is("A0000000043060"));
    }
}