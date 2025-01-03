package ch.schlau.pesche.apidocs.openapi.designfirst.rest;

import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Instance;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbConfig;

import ch.schlau.pesche.apidocs.openapi.designfirst.txproc.model.PanJsonAdapter;
import io.quarkus.jsonb.JsonbConfigCustomizer;

public class JsonConfiguration {

    public static JsonbConfig createJsonbConfig() {
        return new JsonbConfig()
            .withAdapters(new PanJsonAdapter())
            ;
    }

    public static Jsonb createJsonb() {
        return JsonbBuilder.create(createJsonbConfig());
    }

    // Replaces the CDI producer for JsonbConfig built into Quarkus
    @Dependent
    JsonbConfig jsonConfig(Instance<JsonbConfigCustomizer> customizers) {
        JsonbConfig config = createJsonbConfig();

        // Apply all JsonbConfigCustomizer beans (incl. Quarkus)
        for (JsonbConfigCustomizer customizer : customizers) {
            customizer.customize(config);
        }

        return config;
    }
}