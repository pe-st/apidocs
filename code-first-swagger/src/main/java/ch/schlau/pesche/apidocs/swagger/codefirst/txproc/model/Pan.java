package ch.schlau.pesche.apidocs.swagger.codefirst.txproc.model;

import javax.validation.constraints.Pattern;

import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(title = "PAN (Primary Account Number)",
        description = "The number embossed on credit cards",
        type = SchemaType.STRING)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pan {

    @Pattern(regexp = "[0-9]{12,19}")
    private String pan;

    /**
     * For data protection reasons (PCI-DSS compliance) the complete PAN must not
     * be shown unless absolutely needed. This method masks out the middle digits
     * of the PAN, allowing the result to be safely displayed (e.g. on receipts)
     *
     * @return PAN with the middle digits safely replaced by 'x' characters
     */
    public String asMaskedPan() {
        if (pan != null && pan.length() >= 12 && pan.length() <= 19) {
            int lastPos = pan.length() - 4;
            return new StringBuilder(pan).replace(6, lastPos, "xxxxxxxxxxxxxxxxxxx".substring(0, lastPos - 6)).toString();
        } else {
            return pan;
        }
    }
}
