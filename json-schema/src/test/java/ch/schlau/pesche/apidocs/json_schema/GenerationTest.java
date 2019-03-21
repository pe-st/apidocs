package ch.schlau.pesche.apidocs.json_schema;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import ch.schlau.pesche.apidocs.json_schema.generated.PinCheckRequest;

class GenerationTest {

    @Test
    void json_roundtrip() throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        PinCheckRequest request = new PinCheckRequest();
        request.setUuid("abcd");
        request.setPinBlock("secret");

        String jsonString = mapper.writeValueAsString(request);

        assertThat(jsonString, is("{\"uuid\":\"abcd\",\"pinBlock\":\"secret\"}"));

        PinCheckRequest roundtrip = mapper.readerFor(PinCheckRequest.class).readValue(jsonString);
        assertThat(roundtrip.getUuid(), is("abcd"));
    }

}
