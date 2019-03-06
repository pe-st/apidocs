package ch.schlau.pesche.apidocs.spring_restdocs.util;

import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.snippet.Attributes.key;
import static org.springframework.util.StringUtils.collectionToDelimitedString;

import org.springframework.restdocs.constraints.ConstraintDescriptions;
import org.springframework.restdocs.payload.FieldDescriptor;

/**
 * Automatically adds javax.validation.constraints text to the generated snippets.
 * This only makes sense, if you add a request-fields.snippet template containing the "Constraints" column to
 * src/test/resources/org./springframework/restdocs/templates/request-fields.snippet .
 */
public class ConstrainedFields {
    private final ConstraintDescriptions constraintDescriptions;

    public ConstrainedFields(Class<?> input) {
        this.constraintDescriptions = new ConstraintDescriptions(input);
    }

    public FieldDescriptor withPath(String path) {
        String constraints =
                collectionToDelimitedString(this.constraintDescriptions.descriptionsForProperty(path), ". ")
                .replaceAll("\\|", "\\|"); // escape asciidoc table reserved character '|'

        return fieldWithPath(path)
                .attributes(key("constraints").value(constraints));
    }
}
