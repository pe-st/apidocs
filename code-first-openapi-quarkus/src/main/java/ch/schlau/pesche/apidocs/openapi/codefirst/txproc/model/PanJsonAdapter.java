package ch.schlau.pesche.apidocs.openapi.codefirst.txproc.model;

import javax.json.bind.adapter.JsonbAdapter;

public class PanJsonAdapter implements JsonbAdapter<Pan, String> {
    @Override
    public String adaptToJson(Pan pan) throws Exception {
        return pan.getPan();
    }

    @Override
    public Pan adaptFromJson(String s) throws Exception {
        return new Pan(s);
    }
}
