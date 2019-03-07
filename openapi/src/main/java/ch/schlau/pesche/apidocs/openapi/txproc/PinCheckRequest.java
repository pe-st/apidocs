package ch.schlau.pesche.apidocs.openapi.txproc;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(description = "Request for checking a PIN")
public class PinCheckRequest {

    private String uuid;
    private String pinBlock;

    @Schema(description = "Unique ID of the request")
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Schema(description = "Encrypted binary data containing a PIN")
    public String getPinBlock() {
        return pinBlock;
    }

    public void setPinBlock(String pinBlock) {
        this.pinBlock = pinBlock;
    }
}
