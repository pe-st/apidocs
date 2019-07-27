package ch.schlau.pesche.apidocs.openapi.codefirst.txproc;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import lombok.Getter;
import lombok.Setter;

@Schema(description = "Response to PurchaseAuthRequest")
@Getter
@Setter
public class PurchaseAuthResponse {

    public enum Code {
        OK,
        WRONG
    }

    @Schema(description = "Result of the request")
    private Code result;

    @Schema(description = "Code referencing the successful authorization")
    private String approvalCode;
}
