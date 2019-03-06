package ch.schlau.pesche.apidocs.spring_restdocs.txproc;

public class PinCheckRequest {

    private String uuid;
    private String pinBlock;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPinBlock() {
        return pinBlock;
    }

    public void setPinBlock(String pinBlock) {
        this.pinBlock = pinBlock;
    }
}
