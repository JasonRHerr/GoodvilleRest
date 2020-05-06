package Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VinNumberResult implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("Value")
    private String Value;

    @JsonProperty("ValueId")
    private String ValueId;

    @JsonProperty("Variable")
    private String Variable;

    @JsonProperty("VariableId")
    private int VariableId;

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public String getValueId() {
        return ValueId;
    }

    public void setValueId(String valueId) {
        ValueId = valueId;
    }

    public String getVariable() {
        return Variable;
    }

    public void setVariable(String variable) {
        Variable = variable;
    }

    public int getVariableId() {
        return VariableId;
    }

    public void setVariableId(int variableId) {
        VariableId = variableId;
    }

    @Override
    public String toString() {
        return "VehicleInformationResult [Value=" + Value + ", ValueId=" + ValueId + ", " +
                "Variable=" + Variable + ", " + "VariableId=" + VariableId + "]";
    }
}


