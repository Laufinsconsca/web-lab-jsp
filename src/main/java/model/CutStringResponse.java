package model;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "CutStringResponse")
@XmlType(propOrder = {"inputString", "cutLength", "outputString"})
public class CutStringResponse {
    private int cutLength;
    private String inputString;
    private String outputString;

    public CutStringResponse() {
    }

    public CutStringResponse(String inputString, int cutLength, String outputString) {
        this.cutLength = cutLength;
        this.inputString = inputString;
        this.outputString = outputString;
    }

    @XmlElement(name = "inputString")
    public String getInputString() {
        return inputString;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    @XmlElement(name = "cutLength")
    public int getCutLength() {
        return cutLength;
    }

    public void setCutLength(int cutLength) {
        this.cutLength = cutLength;
    }

    @XmlElement(name = "outputString")
    public String getOutputString() {
        return outputString;
    }

    public void setOutputString(String outputString) {
        this.outputString = outputString;
    }
}
