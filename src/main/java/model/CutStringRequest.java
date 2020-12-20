package model;

public class CutStringRequest {
    private int cutLength;
    private String inputString;

    public CutStringRequest() {
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

    public int getCutLength() {
        return cutLength;
    }

    public void setCutLength(int cutLength) {
        this.cutLength = cutLength;
    }
}
