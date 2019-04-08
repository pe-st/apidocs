package ch.schlau.pesche.apidocs.spring_restdocs.rest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.modifyUris;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.restassured3.RestAssuredRestDocumentation.documentationConfiguration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.operation.preprocess.OperationRequestPreprocessor;
import org.springframework.restdocs.payload.PayloadDocumentation;
import org.springframework.restdocs.restassured3.RestAssuredRestDocumentation;

import ch.schlau.pesche.apidocs.spring_restdocs.txproc.PinCheckRequest;
import ch.schlau.pesche.apidocs.spring_restdocs.util.ConstrainedFields;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

@QuarkusTest
@ExtendWith(RestDocumentationExtension.class)
public class TxProcTest {

    private static final OperationRequestPreprocessor preprocessor =
            // Fake scheme, host and port for the docs
            preprocessRequest(modifyUris().scheme("https").host("pesche.schlau.ch").port(8080));

    private RequestSpecification documentationSpec;

    @BeforeEach
    public void setUp(RestDocumentationContextProvider restDocumentation) {
        this.documentationSpec = new RequestSpecBuilder()
                .addFilter(documentationConfiguration(restDocumentation))
                .build();
    }

    @Test
    public void pincheck() {
        ConstrainedFields fields = new ConstrainedFields(PinCheckRequest.class);
        PinCheckRequest request = new PinCheckRequest();
        request.setUuid("cafe");
        request.setPinBlock("secret");

        given(documentationSpec)
                .log().all()
                .accept("application/json")
                .contentType("application/json")
                .body(request)
                .filter(RestAssuredRestDocumentation.document("pincheck", preprocessor,
                        PayloadDocumentation.requestFields(
                                fields.withPath("uuid").description("Just some uuid"),
                                fields.withPath("pinBlock").description("Just some binary data")
                        ), PayloadDocumentation.responseFields(
                                PayloadDocumentation.fieldWithPath("result").description("Just some result code"),
                                PayloadDocumentation.fieldWithPath("tries").description("Just some number")
                        )))
                .when()
                .post("/api/txproc/pincheck")
                .then()
                .assertThat()
                .statusCode(is(200));
    }
}