package ch.schlau.pesche.apidocs.openapi.codefirst.txproc;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import ch.schlau.pesche.apidocs.openapi.codefirst.txproc.doc.Model;
import ch.schlau.pesche.apidocs.openapi.codefirst.txproc.model.Pan;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "Request for checking a PIN")
@Getter
@Setter
public class PinCheckRequest {

    @Schema(description = Model.UUID)
    @NotNull
    private UUID uuid;

    // the class Pan already carries a @Schema annotation
    @NotNull
    private Pan pan;

    @Schema(description = Model.PIN_BLOCK)
    @NotNull
    private String pinBlock;
}
