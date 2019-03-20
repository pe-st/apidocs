package ch.schlau.pesche.apidocs.openapi_lombok.json;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;

class JsonStringTypedefTest {

    private static class SomeProperty extends JsonStringTypedef {
        public SomeProperty() {
        }
        public SomeProperty(String value) {
            super(value);
        }
    }

    @Data
    static class Request {
        SomeProperty someProperty;

        Request() {
            this.someProperty = new SomeProperty();
        }
    }

    @Test
    void json_roundtrip() throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        Request request = new Request();
        request.someProperty.set("xx");

        // JSON serialization
        String jsonString = mapper.writeValueAsString(request);
        assertThat(jsonString, is("{\"someProperty\":\"xx\"}"));

        // JSON deserialization
        Request roundtrip = mapper.readerFor(Request.class).readValue(jsonString);
        assertThat(roundtrip.someProperty.get(), is("xx"));
    }
}