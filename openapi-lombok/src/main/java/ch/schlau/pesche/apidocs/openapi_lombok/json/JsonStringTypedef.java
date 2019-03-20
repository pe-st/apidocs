package ch.schlau.pesche.apidocs.openapi_lombok.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonValue;

//@JsonSerialize(using = JsonStringTypedefSerializer.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class JsonStringTypedef {

    @JsonValue
    private String value;

    public JsonStringTypedef() {
    }

//    @JsonCreator
    public JsonStringTypedef(String value) {
        this.value = value;
    }

//    static JsonStringTypedef<T> of(T value) {
//        return new JsonStringTypedef(value);
//    }
//
//    @JsonGetter
    public String get() {
        return value;
    }

//    @JsonProperty("value")
    public void set(String value) {
        this.value = value;
    }
}
