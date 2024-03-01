package ch.schlau.pesche.apidocs.openapi.codefirst.txproc.model;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import jakarta.json.bind.Jsonb;

import org.junit.jupiter.api.Test;

import ch.schlau.pesche.apidocs.openapi.codefirst.rest.JsonConfiguration;

class PanTest {

    @Test
    void asMaskedPan_valid() {

        assertThat(new Pan("123456789012").asMaskedPan(), is("123456xx9012"));
        assertThat(new Pan("1234567890123456789").asMaskedPan(), is("123456xxxxxxxxx6789"));
    }

    @Test
    void asMaskedPan_invalid() {

        assertThat(new Pan(null).asMaskedPan(), is(nullValue()));
        assertThat(new Pan("1234567890").asMaskedPan(), is("1234567890"));
        assertThat(new Pan("12345678901234567890").asMaskedPan(), is("12345678901234567890"));
    }

    @Test
    void json_roundtrip() {

        Jsonb jsonb = JsonConfiguration.createJsonb();

        Pan pan = new Pan("4444333322221111");

        // JSON serialization
        String jsonString = jsonb.toJson(pan);
        assertThat(jsonString, is("\"4444333322221111\""));

        // JSON deserialization
        Pan roundtrip = jsonb.fromJson(jsonString, Pan.class);
        assertThat(roundtrip.getPan(), is("4444333322221111"));
    }
}