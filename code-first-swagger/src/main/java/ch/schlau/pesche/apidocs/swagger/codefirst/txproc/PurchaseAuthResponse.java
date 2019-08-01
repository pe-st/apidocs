package ch.schlau.pesche.apidocs.swagger.codefirst.txproc;

import io.swagger.v3.oas.annotations.media.Schema;
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
