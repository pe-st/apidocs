package ch.schlau.pesche.apidocs.openapi_lombok.txproc;

import static ch.schlau.pesche.apidocs.openapi_lombok.txproc.doc.Model.PIN_BLOCK;
import static ch.schlau.pesche.apidocs.openapi_lombok.txproc.doc.Model.UUID;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import lombok.Getter;
import lombok.Setter;

@Schema(description = "Request for checking a PIN")
@Getter
@Setter
public class PinCheckRequest {

    @Schema(description = UUID)
    private String uuid;

    @Schema(description = PIN_BLOCK)
    private String pinBlock;
}
