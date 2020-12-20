package model;

import java.io.Serializable;

public class CutStringRequest implements Serializable{
    private Integer cutLength;
    private String inputString;
    private boolean valid;

    public CutStringRequest() {
        cutLength = 0;
        inputString = "";
    }

    public CutStringRequest(String inputString, int cutLength) {
        this.cutLength = cutLength;
        this.inputString = inputString;
    }

    public String getInputString() {
        return inputString;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    public Integer getCutLength() {
        return cutLength;
    }

    public void setCutLength(Integer cutLength) {
        this.cutLength = cutLength;
    }

    public boolean isValid() {
        if (!valid) {
            if (cutLength != 0 && inputString != null){
                valid = true;
                return valid;
            }
        }
        return valid;
    }
}
