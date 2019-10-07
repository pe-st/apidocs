package ch.schlau.pesche.apidocs.swagger.codefirst.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "txproc-code-first-swagger", version = "0.9"))
@ApplicationPath("api")
public class JaxrsApplication extends Application {
}
