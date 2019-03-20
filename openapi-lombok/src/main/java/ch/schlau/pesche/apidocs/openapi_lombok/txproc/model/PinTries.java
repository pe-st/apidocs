package ch.schlau.pesche.apidocs.openapi_lombok.txproc.model;

import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import ch.schlau.pesche.apidocs.openapi_lombok.json.JsonNumberTypedef;

@Schema(type = SchemaType.INTEGER, description = "Number of remaining tries")
public class PinTries extends JsonNumberTypedef<Integer> {
    public PinTries() {
    }

    public PinTries(Integer value) {
        super(value);
    }
}
