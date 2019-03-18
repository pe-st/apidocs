package ch.schlau.pesche.apidocs.openapi_lombok.txproc;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import ch.schlau.pesche.apidocs.openapi_lombok.txproc.model.ApprovalCode;
import lombok.Data;

@Schema(description = "Response to PurchaseAuthRequest")
@Data
public class PurchaseAuthResponse {

    public enum Code {
        OK,
        WRONG
    }

    @Schema(description = "Result of the request")
    private Code result;

    @Schema(implementation = ApprovalCode.class)
    private String approvalCode;
}
