package ch.schlau.pesche.apidocs.openapi_lombok.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "apidocs-openapi-lombok", version = "0.9"))
@ApplicationPath("api")
public class JaxrsApplication extends Application {
}
