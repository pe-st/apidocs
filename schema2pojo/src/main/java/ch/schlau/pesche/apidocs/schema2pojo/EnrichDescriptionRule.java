package ch.schlau.pesche.apidocs.schema2pojo;

import org.jsonschema2pojo.Schema;
import org.jsonschema2pojo.rules.DescriptionRule;

import com.fasterxml.jackson.databind.JsonNode;
import com.sun.codemodel.JDocComment;
import com.sun.codemodel.JDocCommentable;

public class EnrichDescriptionRule extends DescriptionRule {

    @Override
    public JDocComment apply(String nodeName, JsonNode node, JsonNode parent, JDocCommentable generatableType, Schema schema) {
        JDocComment javadoc =  super.apply(nodeName, node, parent, generatableType, schema);

        if (parent.has("ch-schlau-fieldcode")) {
            javadoc.append("\n<p>\nFieldcode: " + parent.get("ch-schlau-fieldcode").asText());
        }

        return javadoc;
    }
}
