package ch.schlau.pesche.apidocs.openapi.codefirst.txproc.model;

import javax.json.bind.annotation.JsonbProperty;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import lombok.Getter;
import lombok.Setter;

/**
 * In the real world this would probably be an Enum with all the known tags
 */
@Schema(title = "EmvTags", description = "Collection of EMV tags")
@Getter
@Setter
public class EmvTags {

    @JsonbProperty("84")
    @Schema(name = "84", title = "Dedicated Filename", description = "The EMV AID as reported by ICC")
    private String x84;

    // no `@JsonbProperty("9F1A")` to observe if the openapi scanner considers the `name`
    @Schema(name = "9F1A", description = "Terminal Country Code")
    private String x9F1A;
}
