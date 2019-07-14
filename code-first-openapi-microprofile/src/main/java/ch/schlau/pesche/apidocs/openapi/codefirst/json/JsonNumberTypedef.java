package ch.schlau.pesche.apidocs.openapi.codefirst.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class JsonNumberTypedef<T extends Number> {

    @JsonValue
    private T value;

    public JsonNumberTypedef() {
    }

    public JsonNumberTypedef(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    public void set(T value) {
        this.value = value;
    }
}
