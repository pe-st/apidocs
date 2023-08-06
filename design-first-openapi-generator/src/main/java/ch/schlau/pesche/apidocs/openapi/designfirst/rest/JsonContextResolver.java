package ch.schlau.pesche.apidocs.openapi.designfirst.rest;

import static ch.schlau.pesche.apidocs.openapi.designfirst.rest.JsonConfiguration.JSONB;

import jakarta.json.bind.Jsonb;
import jakarta.ws.rs.ext.ContextResolver;
import jakarta.ws.rs.ext.Provider;

@Provider
public class JsonContextResolver implements ContextResolver<Jsonb> {

    private final Jsonb jsonb;

    public JsonContextResolver() {
        jsonb = JSONB;
    }

    @Override
    public Jsonb getContext(Class<?> type) {
        return jsonb;
    }
}
