package ch.schlau.pesche.apidocs.swagger.codefirst.txproc;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.UUID;

import jakarta.json.bind.Jsonb;

import org.junit.jupiter.api.Test;

import ch.schlau.pesche.apidocs.swagger.codefirst.rest.JsonConfiguration;
import ch.schlau.pesche.apidocs.swagger.codefirst.txproc.model.EmvTags;
import ch.schlau.pesche.apidocs.swagger.codefirst.txproc.model.Pan;

class PurchaseAuthRequestTest {

    @Test
    void json_roundtrip() {

        Jsonb jsonb = JsonConfiguration.createJsonb();

        PurchaseAuthRequest request = new PurchaseAuthRequest();
        request.setUuid(UUID.fromString("abcdabcd-1234-5678-aaaa-cccccccccccc"));
        request.setPan(new Pan("42"));
        var emvTags = new EmvTags();
        emvTags.setX84("A0000000041010");
        request.setEmvTags(emvTags);

        // JSON serialization
        String jsonString = jsonb.toJson(request);
        assertThat(jsonString, is("{\"emvTags\":{\"84\":\"A0000000041010\"},\"pan\":\"42\",\"uuid\":\"abcdabcd-1234-5678-aaaa-cccccccccccc\"}"));

        // JSON deserialization
        PurchaseAuthRequest roundtrip = jsonb.fromJson(jsonString, PurchaseAuthRequest.class);
        assertThat(roundtrip.getUuid().toString(), is("abcdabcd-1234-5678-aaaa-cccccccccccc"));
    }
}