package ch.schlau.pesche.apidocs.openapi.designfirst.rest;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;

import ch.schlau.pesche.apidocs.openapi.designfirst.txproc.model.PanJsonAdapter;
import lombok.experimental.UtilityClass;

@UtilityClass
public class JsonConfiguration {

    public static final JsonbConfig JSON_CONFIG = new JsonbConfig()
            .withAdapters(new PanJsonAdapter())
            ;

    public static final Jsonb JSONB = JsonbBuilder.create(JSON_CONFIG);
}