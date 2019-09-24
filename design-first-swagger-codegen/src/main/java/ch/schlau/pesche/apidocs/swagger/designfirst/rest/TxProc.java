package ch.schlau.pesche.apidocs.swagger.designfirst.rest;

import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ch.schlau.pesche.apidocs.swagger.designfirst.generated.model.EmvTags;
import ch.schlau.pesche.apidocs.swagger.designfirst.generated.model.PinCheckRequest;
import ch.schlau.pesche.apidocs.swagger.designfirst.generated.model.PinCheckResponse;
import ch.schlau.pesche.apidocs.swagger.designfirst.generated.model.PurchaseAuthRequest;
import ch.schlau.pesche.apidocs.swagger.designfirst.generated.model.PurchaseAuthResponse;
import ch.schlau.pesche.apidocs.swagger.designfirst.txproc.model.Pan;

@Path("/txproc")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TxProc {

    @Path("/pincheck")
    @POST
    public PinCheckResponse pinCheck(PinCheckRequest request) {

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
    public PurchaseAuthResponse purchase(PurchaseAuthRequest request) {

        PurchaseAuthResponse response = new PurchaseAuthResponse();
        if (Optional.ofNullable(request.getPan())
                .map(Pan::getPan)
                .filter(s -> s.startsWith("42"))
                .isPresent()) {
            response.setResult(PurchaseAuthResponse.ResultEnum.OK);
            response.setApprovalCode("OK42." +
                    Optional.ofNullable(request.getEmvTags()).map(EmvTags::get9f1A).orElse("756"));
        } else {
            response.setResult(PurchaseAuthResponse.ResultEnum.WRONG);
        }
        return response;
    }
}
