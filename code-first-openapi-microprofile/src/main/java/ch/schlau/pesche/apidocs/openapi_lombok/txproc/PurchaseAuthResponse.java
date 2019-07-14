package ch.schlau.pesche.apidocs.openapi_lombok.txproc;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import ch.schlau.pesche.apidocs.openapi_lombok.txproc.model.ApprovalCode;
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

    private ApprovalCode approvalCode;
}
