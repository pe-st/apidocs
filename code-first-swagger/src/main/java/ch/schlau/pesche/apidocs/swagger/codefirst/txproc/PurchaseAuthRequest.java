package ch.schlau.pesche.apidocs.swagger.codefirst.txproc;

import java.util.UUID;

import ch.schlau.pesche.apidocs.swagger.codefirst.txproc.model.EmvTags;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "Request for authorizing a Purchase")
@Getter
@Setter
public class PurchaseAuthRequest {

    @Schema(type = "string", description="Unique ID of the request")
    private UUID uuid;

    @Schema(type = "string",
            description = "Token identifying a card, wallet, account etc\n"
                    + "\n"
                    + "May contain alphanumeric characters"
                    + "\n\n"
                    + "Fieldcode: C002")
    private String token;

    private EmvTags emvTags;
}
