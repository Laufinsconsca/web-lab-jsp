package service.impl;

import model.CutStringRequest;
import model.CutStringResponse;
import service.StringService;

public class CutStringServiceImpl implements StringService {

    @Override
    public CutStringResponse performCutString(CutStringRequest cutStringRequest) {
        return new CutStringResponse(
                cutStringRequest.getInputString(),
                cutStringRequest.getCutLength(),
                cutStringRequest.getInputString().substring(cutStringRequest.getCutLength()));
    }
}
