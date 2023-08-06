package ch.schlau.pesche.apidocs.openapi.codefirst.rest;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbConfig;

import ch.schlau.pesche.apidocs.openapi.codefirst.txproc.model.PanJsonAdapter;
import lombok.experimental.UtilityClass;

@UtilityClass
public class JsonConfiguration {

    public static final JsonbConfig JSON_CONFIG = new JsonbConfig()
            .withAdapters(new PanJsonAdapter())
            ;

    public static final Jsonb JSONB = JsonbBuilder.create(JSON_CONFIG);
}