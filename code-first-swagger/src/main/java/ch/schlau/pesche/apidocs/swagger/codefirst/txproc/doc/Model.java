package ch.schlau.pesche.apidocs.swagger.codefirst.txproc.doc;

import lombok.experimental.UtilityClass;

/**
 * Centralized strings for use with [io.swagger.v3.oas.annotations.media.Schema]
 * annotations
 */
@UtilityClass
public class Model {

    public static final String UUID = "Unique ID of the request";

    public static final String PIN_BLOCK = "Encrypted binary data containing a PIN"
            + "\n\nFieldcode: C003";

}
