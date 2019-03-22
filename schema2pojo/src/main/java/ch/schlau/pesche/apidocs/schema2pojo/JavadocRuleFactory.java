package ch.schlau.pesche.apidocs.schema2pojo;

import org.jsonschema2pojo.rules.Rule;
import org.jsonschema2pojo.rules.RuleFactory;

import com.sun.codemodel.JDocComment;
import com.sun.codemodel.JDocCommentable;

public class JavadocRuleFactory extends RuleFactory {

    @Override
    public Rule<JDocCommentable, JDocComment> getDescriptionRule() {
        return new EnrichDescriptionRule();
    }
}
