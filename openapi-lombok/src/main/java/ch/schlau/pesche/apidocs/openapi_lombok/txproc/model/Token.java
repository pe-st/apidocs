package ch.schlau.pesche.apidocs.openapi_lombok.txproc.model;

import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import ch.schlau.pesche.apidocs.openapi_lombok.json.JsonStringTypedef;

@Schema(type = SchemaType.STRING,
        description = "Token identifying a card, wallet, account etc\n"
                + "\n"
                + "May contain alphanumeric characters"
                + "<p>"
                + "Fieldcode: C002")
public class Token extends JsonStringTypedef {
    public Token() {
    }

    public Token(String value) {
        super(value);
    }
}
