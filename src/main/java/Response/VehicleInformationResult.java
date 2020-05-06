package Response;

public class VehicleInformationResult {

    private String valueJson;
    private String valueIdJson;
    private String variableJson;
    private String variableIdJson;

    public VehicleInformationResult(){

    }

    public VehicleInformationResult(String valueJson, String valueIdJson, String variableJson, String variableIdJson){
        this.valueJson = valueJson;
        this.valueIdJson = valueIdJson;
        this.variableJson = variableJson;
        this.variableIdJson = variableIdJson;
    }

    public String getValueJson() {
        return valueJson;
    }

    public void setValueJson(String valueJson) {
        this.valueJson = valueJson;
    }

    public String getValueIdJson() {
        return valueIdJson;
    }

    public void setValueIdJson(String valueIdJson) {
        this.valueIdJson = valueIdJson;
    }

    public String getVariableJson() {
        return variableJson;
    }

    public void setVariableJson(String variableJson) {
        this.variableJson = variableJson;
    }

    public String getVariableIdJson() {
        return variableIdJson;
    }

    public void setVariableIdJson(String variableIdJson) {
        this.variableIdJson = variableIdJson;
    }

    @Override
    public String toString()
    {
        return "VehicleInformationResult [valueJson=" + valueJson + ", valueIdJson=" + valueIdJson + ", " +
                "variableJson=" + variableJson + "variableIdJson=" + variableIdJson + "]";
    }
}
