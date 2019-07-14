package ch.schlau.pesche.apidocs.openapi_lombok.txproc.model;

import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import ch.schlau.pesche.apidocs.openapi_lombok.json.JsonStringTypedef;

@Schema(type = SchemaType.STRING, description="Unique ID of the request")
public class RequestUuid extends JsonStringTypedef {
    public RequestUuid() {
    }

    public RequestUuid(String value) {
        super(value);
    }
}
