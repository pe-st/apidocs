package ch.schlau.pesche.apidocs.openapi.codefirst.txproc;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import ch.schlau.pesche.apidocs.openapi.codefirst.txproc.model.PinTries;
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

    private PinTries tries;
}
