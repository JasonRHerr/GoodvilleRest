package Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VehicleInformationList implements Serializable {

    @JsonProperty("Count")
    private String Count;

    @JsonProperty("Message")
    private String Message;

    @JsonProperty("SearchCriteria")
    private String SearchCriteria;

    @JsonProperty("Results")
    private List<VinNumberResult> Results;

    public List<VinNumberResult> getResults() {
        return Results;
    }

    public void setResults(List<VinNumberResult> results) {
        this.Results = results;
    }

    public String getCount() {
        return Count;
    }

    public void setCount(String count) {
        Count = count;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getSearchCriteria() {
        return SearchCriteria;
    }

    public void setSearchCriteria(String searchCriteria) {
        SearchCriteria = searchCriteria;
    }

    @Override
    public String toString() {
        return "Count=" + Count + "Message=" + Message + ", " +
        "SearchCriteria=" + SearchCriteria + "Results: " + Results.toString() + "]";
    }
}
