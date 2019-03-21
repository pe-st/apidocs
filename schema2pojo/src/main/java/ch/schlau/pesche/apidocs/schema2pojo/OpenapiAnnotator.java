package ch.schlau.pesche.apidocs.schema2pojo;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.jsonschema2pojo.AbstractAnnotator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JFieldVar;

public class OpenapiAnnotator extends AbstractAnnotator {

    @Override
    public void propertyField(JFieldVar field, JDefinedClass clazz, String propertyName, JsonNode propertyNode) {
        if (propertyNode.has("description")) {
            field.annotate(Schema.class).param("description", propertyNode.get("description").asText());
        }
    }

    /**
     * There are two methods that are called for a class context, this one and
     * {@link #propertyOrder(JDefinedClass, JsonNode)}; but only this one gets
     * the complete schema as parameter
     *
     * @param clazz
     * @param schema
     */
    @Override
    public void propertyInclusion(JDefinedClass clazz, JsonNode schema) {

        clazz.annotate(JsonIgnoreProperties.class).param("ignoreUnknown",true);

        if (schema.has("description")) {
            clazz.annotate(Schema.class).param("description", schema.get("description").asText());
        }
    }
}
