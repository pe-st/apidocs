package ch.schlau.pesche.apidocs.swagger.codefirst.txproc;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

import ch.schlau.pesche.apidocs.swagger.codefirst.txproc.doc.Model;
import ch.schlau.pesche.apidocs.swagger.codefirst.txproc.model.EmvTags;
import ch.schlau.pesche.apidocs.swagger.codefirst.txproc.model.Pan;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "Request for authorizing a Purchase")
@Getter
@Setter
public class PurchaseAuthRequest {

    @Schema(description = Model.UUID)
    @NotNull
    private UUID uuid;

    // the class Pan already carries a @Schema annotation
    @NotNull
    private Pan pan;

    // the class EmvTags already carries a @Schema annotation
    private EmvTags emvTags;
}
