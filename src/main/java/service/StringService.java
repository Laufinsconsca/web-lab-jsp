package service;

import model.CutStringRequest;
import model.CutStringResponse;

public interface StringService {
    CutStringResponse performCutString(CutStringRequest cutStringRequest);
}
