package ch.schlau.pesche.apidocs.openapi.designfirst.rest;

import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ch.schlau.pesche.apidocs.openapi.designfirst.generated.model.PinCheckRequest;
import ch.schlau.pesche.apidocs.openapi.designfirst.generated.model.PinCheckResponse;
import ch.schlau.pesche.apidocs.openapi.designfirst.generated.model.PurchaseAuthRequest;
import ch.schlau.pesche.apidocs.openapi.designfirst.generated.model.PurchaseAuthResponse;

@Path("/txproc")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TxProc {

    @Path("/pincheck")
    @POST
//    @Operation(summary = "Check the pin")
//    @APIResponse(description = "PIN Check Response",
//                 content = @Content(schema = @Schema(implementation = PinCheckResponse.class)))
    public PinCheckResponse pinCheck(
            /*@RequestBody(description = "PIN Check Request Body",
                         content = @Content(schema = @Schema(implementation = PinCheckRequest.class))
            )*/ PinCheckRequest request) {

        PinCheckResponse response = new PinCheckResponse();
        if ("magic".equals(request.getPinBlock())) {
            response.setResult(PinCheckResponse.ResultEnum.OK);
            response.setTries(3);
        } else {
            response.setResult(PinCheckResponse.ResultEnum.WRONG);
        }
        return response;
    }

    @Path("/purchase")
    @POST
//    @Operation(summary = "Authorize a Purchase")
//    @APIResponse(description = "Purchase Response",
//                 content = @Content(schema = @Schema(implementation = PurchaseAuthResponse.class)))
    public PurchaseAuthResponse purchase(
            /*@RequestBody(description = "Purchase Request Body",
                         content = @Content(schema = @Schema(implementation = PurchaseAuthRequest.class))
            )*/ PurchaseAuthRequest request) {

        PurchaseAuthResponse response = new PurchaseAuthResponse();
        if (Optional.ofNullable(request.getToken())
                .filter(s -> s.startsWith("42"))
                .isPresent()) {
            response.setResult(PurchaseAuthResponse.ResultEnum.OK);
            response.setApprovalCode("OK42");
        } else {
            response.setResult(PurchaseAuthResponse.ResultEnum.WRONG);
        }
        return response;
    }

}
