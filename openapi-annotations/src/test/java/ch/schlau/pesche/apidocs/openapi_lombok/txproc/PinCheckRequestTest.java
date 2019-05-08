package ch.schlau.pesche.apidocs.openapi_lombok.txproc;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

class PinCheckRequestTest {

    @Test
    void json_roundtrip() throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        PinCheckRequest request = new PinCheckRequest();
        request.setUuid("abcd-1234");

        // JSON serialization
        String jsonString = mapper.writeValueAsString(request);
        assertThat(jsonString, is("{\"uuid\":\"abcd-1234\",\"pinBlock\":null}"));

        // JSON deserialization
        PinCheckRequest roundtrip = mapper.readerFor(PinCheckRequest.class).readValue(jsonString);
        assertThat(roundtrip.getUuid(), is("abcd-1234"));
    }
}