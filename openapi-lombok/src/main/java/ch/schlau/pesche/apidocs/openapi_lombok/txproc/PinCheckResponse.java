package ch.schlau.pesche.apidocs.openapi_lombok.txproc;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import lombok.Getter;
import lombok.Setter;

@Schema(description = "Tells if the PIN in the request was correct")
@Getter
@Setter
public class PinCheckResponse {

    public enum Code {
        OK,
        WRONG
    }

    @Schema(description = "Result of the request"/*, enumeration = {"OK", "WRONG"}*/)
    private Code result;

    @Schema(description = "Number of remaining tries")
    private int tries;
}
