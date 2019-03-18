package ch.schlau.pesche.apidocs.openapi_lombok.txproc;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import ch.schlau.pesche.apidocs.openapi_lombok.txproc.model.RequestUuid;
import ch.schlau.pesche.apidocs.openapi_lombok.txproc.model.Token;
import lombok.Data;

@Schema(description = "Request for authorizing a Purchase")
@Data
public class PurchaseAuthRequest {

    @Schema(implementation = RequestUuid.class)
    private String uuid;

    private Token token;
}
