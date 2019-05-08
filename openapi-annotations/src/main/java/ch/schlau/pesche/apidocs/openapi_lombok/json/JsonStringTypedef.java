package ch.schlau.pesche.apidocs.openapi_lombok.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class JsonStringTypedef {

    @JsonValue
    private String value;

    public JsonStringTypedef() {
    }

    public JsonStringTypedef(String value) {
        this.value = value;
    }

    public String get() {
        return value;
    }

    public void set(String value) {
        this.value = value;
    }
}
