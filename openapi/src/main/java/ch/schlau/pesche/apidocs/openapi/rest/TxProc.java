package ch.schlau.pesche.apidocs.openapi.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;

import ch.schlau.pesche.apidocs.openapi.txproc.PinCheckRequest;
import ch.schlau.pesche.apidocs.openapi.txproc.PinCheckResponse;

@Path("/txproc")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TxProc {

    @Operation(summary = "Check the pin")
    @Path("/pincheck")
    @POST
    public PinCheckResponse pinCheck(PinCheckRequest request) {
        PinCheckResponse response = new PinCheckResponse();
        if ("magic".equals(request.getPinBlock())) {
            response.setResult(PinCheckResponse.Code.OK);
            response.setTries(3);
        } else {
            response.setResult(PinCheckResponse.Code.WRONG);
        }
        return response;
    }

}
