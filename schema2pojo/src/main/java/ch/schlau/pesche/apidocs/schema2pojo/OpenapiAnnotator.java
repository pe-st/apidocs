package ch.schlau.pesche.apidocs.schema2pojo;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.jsonschema2pojo.AbstractAnnotator;

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
}
