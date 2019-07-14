package ch.schlau.pesche.apidocs.openapi.codefirst.txproc;

import java.util.UUID;

import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import ch.schlau.pesche.apidocs.openapi.codefirst.txproc.model.EmvTags;
import ch.schlau.pesche.apidocs.openapi.codefirst.txproc.model.Token;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "Request for authorizing a Purchase")
@Getter
@Setter
public class PurchaseAuthRequest {

    @Schema(type = SchemaType.STRING, description="Unique ID of the request")
    private UUID uuid;

    private Token token;

    private EmvTags emvTags;
}
