package ch.schlau.pesche.apidocs.swagger.codefirst.txproc;

import static ch.schlau.pesche.apidocs.swagger.codefirst.rest.JsonConfiguration.JSONB;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.UUID;

import org.junit.jupiter.api.Test;

import ch.schlau.pesche.apidocs.swagger.codefirst.txproc.model.EmvTags;
import ch.schlau.pesche.apidocs.swagger.codefirst.txproc.model.Pan;

class PurchaseAuthRequestTest {

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