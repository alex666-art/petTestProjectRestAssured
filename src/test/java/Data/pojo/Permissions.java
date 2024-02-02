package Data.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Permissions {
    public Integer type;
    public String label;
    public Integer dataspace;
    @JsonProperty("case")
    public Integer mycase;

    public Integer getType() {
        return type;
    }

    public String getLabel() {
        return label;
    }

    public Integer getDataspace() {
        return dataspace;
    }

    public Integer getMycase() {
        return mycase;
    }
}