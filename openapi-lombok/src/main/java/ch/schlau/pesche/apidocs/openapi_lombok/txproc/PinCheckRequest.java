package ch.schlau.pesche.apidocs.openapi_lombok.txproc;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import ch.schlau.pesche.apidocs.openapi_lombok.txproc.model.RequestUuid;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "Request for checking a PIN")
@Getter
@Setter
public class PinCheckRequest {

    private RequestUuid uuid;

    @Schema(description = "Encrypted binary data containing a PIN")
    private String pinBlock;
}
