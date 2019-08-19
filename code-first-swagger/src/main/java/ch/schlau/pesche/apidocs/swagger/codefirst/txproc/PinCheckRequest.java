package ch.schlau.pesche.apidocs.swagger.codefirst.txproc;

import java.util.UUID;

import ch.schlau.pesche.apidocs.swagger.codefirst.txproc.doc.Model;
import ch.schlau.pesche.apidocs.swagger.codefirst.txproc.model.Pan;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "Request for checking a PIN")
@Getter
@Setter
public class PinCheckRequest {

    @Schema(type = "string", description = Model.UUID)
    private UUID uuid;

    // the class Pan already carries a @Schema annotation
    private Pan pan;

    @Schema(description = Model.PIN_BLOCK)
    private String pinBlock;
}
