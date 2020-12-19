package service.impl;

import model.CutStringResponse;
import service.StringService;

public class CutStringServiceImpl implements StringService {

    @Override
    public CutStringResponse perform(String inputString, int cutLength) {
        return new CutStringResponse(inputString, cutLength, inputString.substring(cutLength));
    }
}
