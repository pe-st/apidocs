package ch.schlau.pesche.apidocs.openapi.codefirst.rest;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "txproc-code-first-openapi", version = "0.9"))
@ApplicationPath("/api")
public class JaxrsApplication extends Application {
}
