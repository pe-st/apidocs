package ch.schlau.pesche.apidocs.swagger.codefirst.txproc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.v3.oas.annotations.media.Schema;
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
