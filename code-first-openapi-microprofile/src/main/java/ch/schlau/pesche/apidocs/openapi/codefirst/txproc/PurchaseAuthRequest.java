package ch.schlau.pesche.apidocs.openapi.codefirst.txproc;

import java.util.UUID;

import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import ch.schlau.pesche.apidocs.openapi.codefirst.txproc.model.EmvTags;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "Request for authorizing a Purchase")
@Getter
@Setter
public class PurchaseAuthRequest {

    @Schema(type = SchemaType.STRING, description="Unique ID of the request")
    private UUID uuid;

    @Schema(type = SchemaType.STRING,
            description = "Token identifying a card, wallet, account etc\n"
                    + "\n"
                    + "May contain alphanumeric characters"
                    + "\n\n"
                    + "Fieldcode: C002")
    private String token;

    private EmvTags emvTags;
}
