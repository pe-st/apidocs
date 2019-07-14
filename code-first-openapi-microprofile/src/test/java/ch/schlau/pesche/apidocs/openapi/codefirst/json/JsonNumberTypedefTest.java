package ch.schlau.pesche.apidocs.openapi.codefirst.json;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import lombok.Setter;

class JsonNumberTypedefTest {

    private static class SomeProperty extends JsonNumberTypedef<Integer> {
        public SomeProperty() {
        }
        public SomeProperty(Integer value) {
            super(value);
        }
    }

    @Getter
    @Setter
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
        request.someProperty.set(42);

        // JSON serialization
        String jsonString = mapper.writeValueAsString(request);
        assertThat(jsonString, is("{\"someProperty\":42}"));

        // JSON deserialization
        Request roundtrip = mapper.readerFor(Request.class).readValue(jsonString);
        assertThat(roundtrip.someProperty.get(), is(42));
    }
}