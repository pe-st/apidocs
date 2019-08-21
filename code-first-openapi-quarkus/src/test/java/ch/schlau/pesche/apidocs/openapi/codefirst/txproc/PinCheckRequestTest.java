package ch.schlau.pesche.apidocs.openapi.codefirst.txproc;

import static ch.schlau.pesche.apidocs.openapi.codefirst.rest.JsonConfiguration.JSONB;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.UUID;

import org.junit.jupiter.api.Test;

import ch.schlau.pesche.apidocs.openapi.codefirst.txproc.model.Pan;

class PinCheckRequestTest {

    @Test
    void json_roundtrip() {

        PinCheckRequest request = new PinCheckRequest();
        request.setUuid(UUID.fromString("abcdabcd-1234-5678-aaaa-cccccccccccc"));

        // JSON serialization
        String jsonString1 = JSONB.toJson(request);
        assertThat(jsonString1, is("{\"uuid\":\"abcdabcd-1234-5678-aaaa-cccccccccccc\"}"));

        // set the other properties as well
        request.setPan(new Pan("111222333444"));
        request.setPinBlock("-secret-");
        String jsonString2 = JSONB.toJson(request);
        assertThat(jsonString2, is("{\"pan\":\"111222333444\",\"pinBlock\":\"-secret-\",\"uuid\":\"abcdabcd-1234-5678-aaaa-cccccccccccc\"}"));

        // JSON deserialization
        PinCheckRequest roundtrip = JSONB.fromJson(jsonString2, PinCheckRequest.class);
        assertThat(roundtrip.getUuid().toString(), is("abcdabcd-1234-5678-aaaa-cccccccccccc"));
        assertThat(roundtrip.getPan().getPan(), is("111222333444"));
        assertThat(roundtrip.getPinBlock(), is("-secret-"));
    }
}
