package ch.schlau.pesche.apidocs.openapi.codefirst.rest;

import java.util.Optional;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import ch.schlau.pesche.apidocs.openapi.codefirst.txproc.PinCheckRequest;
import ch.schlau.pesche.apidocs.openapi.codefirst.txproc.PinCheckResponse;
import ch.schlau.pesche.apidocs.openapi.codefirst.txproc.PurchaseAuthRequest;
import ch.schlau.pesche.apidocs.openapi.codefirst.txproc.PurchaseAuthResponse;
import ch.schlau.pesche.apidocs.openapi.codefirst.txproc.model.EmvTags;
import ch.schlau.pesche.apidocs.openapi.codefirst.txproc.model.Pan;

@Path("/txproc")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TxProc {

    @Path("/pincheck")
    @POST
    @Operation(summary = "Check the pin")
    @APIResponse(description = "PIN Check Response",
                 content = @Content(schema = @Schema(implementation = PinCheckResponse.class)))
    public PinCheckResponse pinCheck(
            @RequestBody(description = "PIN Check Request Body",
                         content = @Content(schema = @Schema(implementation = PinCheckRequest.class)),
                         required = true
            ) PinCheckRequest request) {

        PinCheckResponse response = new PinCheckResponse();
        if ("magic".equals(request.getPinBlock())) {
            response.setResult(PinCheckResponse.Code.OK);
            response.setTries(3);
        } else {
            response.setResult(PinCheckResponse.Code.WRONG);
        }
        return response;
    }

    @Path("/purchase")
    @POST
    @Operation(summary = "Authorize a Purchase")
    @APIResponse(description = "Purchase Response",
                 content = @Content(schema = @Schema(implementation = PurchaseAuthResponse.class)))
    public PurchaseAuthResponse purchase(
            @RequestBody(description = "Purchase Request Body",
                         content = @Content(schema = @Schema(implementation = PurchaseAuthRequest.class)),
                         required = true
            ) PurchaseAuthRequest request) {

        PurchaseAuthResponse response = new PurchaseAuthResponse();
        if (Optional.ofNullable(request.getPan())
                .map(Pan::getPan)
                .filter(s -> s.startsWith("42"))
                .isPresent()) {
            response.setResult(PurchaseAuthResponse.Code.OK);
            response.setApprovalCode("OK42." +
                    Optional.ofNullable(request.getEmvTags()).map(EmvTags::getX9F1A).orElse("756"));
        } else {
            response.setResult(PurchaseAuthResponse.Code.WRONG);
        }
        return response;
    }

}
