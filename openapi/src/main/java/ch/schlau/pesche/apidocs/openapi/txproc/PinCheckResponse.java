package ch.schlau.pesche.apidocs.openapi.txproc;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(description = "Tells if the PIN in the request was correct")
public class PinCheckResponse {

    public enum Code {
        OK,
        WRONG
    }

    private Code result;
    private int tries;

    @Schema(description = "Result of the request"/*, enumeration = {"OK", "WRONG"}*/)
    public Code getResult() {
        return result;
    }

    public void setResult(Code result) {
        this.result = result;
    }

    @Schema(description = "Number of remaining tries")
    public int getTries() {
        return tries;
    }

    public void setTries(int tries) {
        this.tries = tries;
    }
}
