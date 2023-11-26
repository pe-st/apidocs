package ch.schlau.pesche.apidocs.openapi.codefirst.txproc;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import lombok.Getter;
import lombok.Setter;

@Schema(description = "Response to PurchaseAuthRequest")
@Getter
@Setter
public class PurchaseAuthResponse {

    @Schema(description = "Result of the request")
    public enum Code {
        OK,
        WRONG
    }

    // the enum Code already carries a @Schema annotation
    private Code result;

    @Schema(description = "Code referencing the successful authorization")
    private String approvalCode;
}
