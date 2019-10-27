package ch.schlau.pesche.apidocs.swagger.designfirst.rest;

import static ch.schlau.pesche.apidocs.swagger.designfirst.rest.JsonConfiguration.JSONB;

import javax.json.bind.Jsonb;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

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
