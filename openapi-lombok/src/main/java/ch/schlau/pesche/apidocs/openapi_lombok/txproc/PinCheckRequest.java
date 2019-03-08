package ch.schlau.pesche.apidocs.openapi_lombok.txproc;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import lombok.Data;

@Schema(description = "Request for checking a PIN")
@Data
public class PinCheckRequest {

    @Schema(description = "Unique ID of the request")
    private String uuid;

    @Schema(description = "Encrypted binary data containing a PIN")
    private String pinBlock;
}
