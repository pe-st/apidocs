package ch.schlau.pesche.apidocs.openapi.codefirst.txproc.model;

import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import ch.schlau.pesche.apidocs.openapi.codefirst.json.JsonStringTypedef;

@Schema(type = SchemaType.STRING,
        description = "Token identifying a card, wallet, account etc\n"
                + "\n"
                + "May contain alphanumeric characters"
                + "\n\n"
                + "Fieldcode: C002")
public class Token extends JsonStringTypedef {
    public Token() {
    }

    public Token(String value) {
        super(value);
    }
}
