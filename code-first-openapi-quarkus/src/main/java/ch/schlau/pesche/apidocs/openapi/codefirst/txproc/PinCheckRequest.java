package ch.schlau.pesche.apidocs.openapi.codefirst.txproc;

import java.util.UUID;

import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import ch.schlau.pesche.apidocs.openapi.codefirst.txproc.doc.Model;
import ch.schlau.pesche.apidocs.openapi.codefirst.txproc.model.Pan;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "Request for checking a PIN",
        requiredProperties = {"uuid", "pan", "pinBlock"})
@Getter
@Setter
public class PinCheckRequest {

    @Schema(type = SchemaType.STRING, description = Model.UUID)
    private UUID uuid;

    // the class Pan already carries a @Schema annotation
    private Pan pan;

    @Schema(description = Model.PIN_BLOCK)
    private String pinBlock;
}
