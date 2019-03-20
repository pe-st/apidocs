package ch.schlau.pesche.apidocs.openapi_lombok.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import ch.schlau.pesche.apidocs.openapi_lombok.txproc.PinCheckRequest;
import ch.schlau.pesche.apidocs.openapi_lombok.txproc.PinCheckResponse;
import ch.schlau.pesche.apidocs.openapi_lombok.txproc.PurchaseAuthRequest;
import ch.schlau.pesche.apidocs.openapi_lombok.txproc.PurchaseAuthResponse;
import ch.schlau.pesche.apidocs.openapi_lombok.txproc.model.ApprovalCode;
import ch.schlau.pesche.apidocs.openapi_lombok.txproc.model.PinTries;

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
                         content = @Content(schema = @Schema(implementation = PinCheckRequest.class))
            ) PinCheckRequest request) {

        PinCheckResponse response = new PinCheckResponse();
        if ("magic".equals(request.getPinBlock())) {
            response.setResult(PinCheckResponse.Code.OK);
            response.setTries(new PinTries(3));
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
                         content = @Content(schema = @Schema(implementation = PurchaseAuthRequest.class))
            ) PurchaseAuthRequest request) {

        PurchaseAuthResponse response = new PurchaseAuthResponse();
        if ("42".equals(request.getToken().get())) {
            response.setResult(PurchaseAuthResponse.Code.OK);
            response.setApprovalCode(new ApprovalCode("OK42"));
        } else {
            response.setResult(PurchaseAuthResponse.Code.WRONG);
        }
        return response;
    }

}
