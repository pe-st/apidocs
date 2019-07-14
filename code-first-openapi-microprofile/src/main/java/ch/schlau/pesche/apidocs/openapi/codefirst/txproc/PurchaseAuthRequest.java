package ch.schlau.pesche.apidocs.openapi.codefirst.txproc;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import ch.schlau.pesche.apidocs.openapi.codefirst.txproc.model.RequestUuid;
import ch.schlau.pesche.apidocs.openapi.codefirst.txproc.model.EmvTags;
import ch.schlau.pesche.apidocs.openapi.codefirst.txproc.model.Token;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "Request for authorizing a Purchase")
@Getter
@Setter
public class PurchaseAuthRequest {

    private RequestUuid uuid;

    private Token token;

    private EmvTags emvTags;
}
