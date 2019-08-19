package ch.schlau.pesche.apidocs.swagger.codefirst.txproc;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "Tells if the PIN in the request was correct")
@Getter
@Setter
public class PinCheckResponse {

    @Schema(description = "Result of the request")
    public enum Code {
        OK,
        WRONG
    }

    // the enum Code already carries a @Schema annotation
    private Code result;

    @Schema(description = "Number of remaining tries")
    private int tries;
}
