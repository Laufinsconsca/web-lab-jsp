package service;

import model.CutStringResponse;

public interface StringService {
    CutStringResponse perform(String inputString, int cutLength);
}
