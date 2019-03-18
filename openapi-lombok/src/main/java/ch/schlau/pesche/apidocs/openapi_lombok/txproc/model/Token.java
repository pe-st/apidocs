package ch.schlau.pesche.apidocs.openapi_lombok.txproc.model;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import lombok.Data;

@Schema(description = "Token identifying a card, wallet, account etc")
@Data
public class Token {

    // TODO rather use a generic wrapper class to avoid an additional JSON object
    String token;
}
