package ch.schlau.pesche.apidocs.openapi.codefirst.txproc;

import java.util.UUID;

import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import ch.schlau.pesche.apidocs.openapi.codefirst.txproc.doc.Model;
import ch.schlau.pesche.apidocs.openapi.codefirst.txproc.model.EmvTags;
import ch.schlau.pesche.apidocs.openapi.codefirst.txproc.model.Pan;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "Request for authorizing a Purchase")
@Getter
@Setter
public class PurchaseAuthRequest {

    @Schema(type = SchemaType.STRING, description = Model.UUID)
    private UUID uuid;

    // the class Pan already carries a @Schema annotation
    private Pan pan;

    @Schema(type = SchemaType.STRING,
            description = "Token identifying a card, wallet, account etc\n"
                    + "\n"
                    + "May contain alphanumeric characters"
                    + "\n\n"
                    + "Fieldcode: C002")
    private String token;

    private EmvTags emvTags;
}
