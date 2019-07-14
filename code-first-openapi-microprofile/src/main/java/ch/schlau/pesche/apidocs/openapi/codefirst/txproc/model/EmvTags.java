
package ch.schlau.pesche.apidocs.openapi.codefirst.txproc.model;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

/**
 * In the real world this would probably be an Enum with all the known tags
 */
@Schema(title = "EmvTags", description = "Collection of EMV tags")
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmvTags {

    @Schema(name = "84", title = "Dedicated Filename", description = "The EMV AID as reported by ICC")
    private String x84;

    @Schema(name = "9F1A", description = "Terminal Country Code")
    private String x9F1A;
}
