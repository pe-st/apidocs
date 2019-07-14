package ch.schlau.pesche.apidocs.openapi.codefirst.txproc;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import ch.schlau.pesche.apidocs.openapi.codefirst.txproc.model.EmvTags;
import ch.schlau.pesche.apidocs.openapi.codefirst.txproc.model.RequestUuid;
import ch.schlau.pesche.apidocs.openapi.codefirst.txproc.model.Token;

class PurchaseAuthRequestTest {

    @Test
    void json_roundtrip() throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        PurchaseAuthRequest request = new PurchaseAuthRequest();
        request.setUuid(new RequestUuid("abcd-1234"));
        request.setToken(new Token("42"));
        var emvTags = new EmvTags();
        emvTags.setX84("ABC=");
        request.setEmvTags(emvTags);

        // JSON serialization
        String jsonString = mapper.writeValueAsString(request);
        assertThat(jsonString, is("{\"uuid\":\"abcd-1234\",\"token\":\"42\",\"emvTags\":{\"x84\":\"ABC=\"}}"));

        // JSON deserialization
        PurchaseAuthRequest roundtrip = mapper.readerFor(PurchaseAuthRequest.class).readValue(jsonString);
        assertThat(roundtrip.getUuid().get(), is("abcd-1234"));
    }
}