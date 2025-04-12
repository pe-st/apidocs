package ch.schlau.pesche.apidocs.quarkiverse.designfirst.rest;

import java.util.Optional;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import ch.schlau.pesche.apidocs.quarkiverse.designfirst.generated.model.beans.EmvTags;
import ch.schlau.pesche.apidocs.quarkiverse.designfirst.generated.model.beans.PinCheckRequest;
import ch.schlau.pesche.apidocs.quarkiverse.designfirst.generated.model.beans.PinCheckResponse;
import ch.schlau.pesche.apidocs.quarkiverse.designfirst.generated.model.beans.PurchaseAuthRequest;
import ch.schlau.pesche.apidocs.quarkiverse.designfirst.generated.model.beans.PurchaseAuthResponse;

@Path("/txproc")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TxProc /*implements ApiResource*/ {

    @Path("/pincheck")
    @POST
    public PinCheckResponse pinCheck(PinCheckRequest request) {

        PinCheckResponse response = new PinCheckResponse();
        if ("magic".equals(request.getPinBlock())) {
            response.setResult(PinCheckResponse.Result.OK);
            response.setTries(3);
        } else {
            response.setResult(PinCheckResponse.Result.WRONG);
        }
        return response;
    }

    @Path("/purchase")
    @POST
    public PurchaseAuthResponse purchase(PurchaseAuthRequest request) {

        PurchaseAuthResponse response = new PurchaseAuthResponse();
        if (Optional.ofNullable(request.getPan())
                .filter(s -> s.startsWith("42"))
                .isPresent()) {
            response.setResult(PurchaseAuthResponse.Result.OK);
            response.setApprovalCode("OK42." +
                    Optional.ofNullable(request.getEmvTags()).map(EmvTags::get9f1a).orElse("756"));
        } else {
            response.setResult(PurchaseAuthResponse.Result.WRONG);
        }
        return response;
    }
}
