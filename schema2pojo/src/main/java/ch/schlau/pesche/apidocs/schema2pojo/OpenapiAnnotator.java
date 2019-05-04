package ch.schlau.pesche.apidocs.schema2pojo;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.jsonschema2pojo.AbstractAnnotator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;
import com.sun.codemodel.JAnnotationUse;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JFieldVar;

import lombok.Getter;
import lombok.Setter;

public class OpenapiAnnotator extends AbstractAnnotator {

    private static final String DESCRIPTION = "description";
    private static final String TITLE = "title";
    private static final String NAME = "name";

    @Override
    public void propertyField(JFieldVar field, JDefinedClass clazz, String propertyName, JsonNode propertyNode) {
        if (propertyNode.has(DESCRIPTION)) {
            StringBuilder description = new StringBuilder(propertyNode.get(DESCRIPTION).asText());

            if (propertyNode.has("ch-schlau-fieldcode")) {
                description
                        .append("\n\nFieldcode: ")
                        .append(propertyNode.get("ch-schlau-fieldcode").asText());
            }

            field.annotate(Schema.class)
                    .param(NAME, propertyName)
                    .param(DESCRIPTION, description.toString());
        }
    }

    /**
     * Annotate a class with {@link Schema}
     * <p>
     * There are two methods that are called for a class context, this one and
     * {@link #propertyOrder(JDefinedClass, JsonNode)}; but only this one gets
     * the complete schema as parameter
     *
     * @param clazz
     * @param schema
     */
    @Override
    public void propertyInclusion(JDefinedClass clazz, JsonNode schema) {

        clazz.annotate(JsonIgnoreProperties.class).param("ignoreUnknown", true);

        JAnnotationUse schemaAnnotation = clazz.annotate(Schema.class);
        if (schema.has(TITLE)) {
            schemaAnnotation.param(TITLE, schema.get(TITLE).asText());
        }
        if (schema.has(DESCRIPTION)) {
            schemaAnnotation.param(DESCRIPTION, schema.get(DESCRIPTION).asText());
        }

        // add also lombok annotations, permitting to use lombok to
        // propagate the OpenAPI annotations from the fields to the getters/setters
        clazz.annotate(Getter.class);
        clazz.annotate(Setter.class);
    }
}
