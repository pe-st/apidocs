package ch.schlau.pesche.apidocs.spring_restdocs.txproc;

public class PinCheckResponse {

    public enum Code {
        OK,
        WRONG
    }

    private Code result;
    private int tries;

    public Code getResult() {
        return result;
    }

    public void setResult(Code result) {
        this.result = result;
    }

    public int getTries() {
        return tries;
    }

    public void setTries(int tries) {
        this.tries = tries;
    }
}
