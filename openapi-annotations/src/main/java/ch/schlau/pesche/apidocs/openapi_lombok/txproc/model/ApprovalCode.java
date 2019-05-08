package ch.schlau.pesche.apidocs.openapi_lombok.txproc.model;

import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import ch.schlau.pesche.apidocs.openapi_lombok.json.JsonStringTypedef;

@Schema(type = SchemaType.STRING, description = "Code referencing the successful authorization")
public class ApprovalCode extends JsonStringTypedef {
    public ApprovalCode() {
    }

    public ApprovalCode(String value) {
        super(value);
    }
}
