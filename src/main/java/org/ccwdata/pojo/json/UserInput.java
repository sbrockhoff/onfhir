
package org.ccwdata.pojo.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
    "sources",
    "rxcui"
})
public class UserInput {

    @JsonProperty("sources")
    private List<String> sources = new ArrayList<String>();
    @JsonProperty("rxcui")
    private String rxcui;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The sources
     */
    @JsonProperty("sources")
    public List<String> getSources() {
        return sources;
    }

    /**
     * 
     * @param sources
     *     The sources
     */
    @JsonProperty("sources")
    public void setSources(List<String> sources) {
        this.sources = sources;
    }

    /**
     * 
     * @return
     *     The rxcui
     */
    @JsonProperty("rxcui")
    public String getRxcui() {
        return rxcui;
    }

    /**
     * 
     * @param rxcui
     *     The rxcui
     */
    @JsonProperty("rxcui")
    public void setRxcui(String rxcui) {
        this.rxcui = rxcui;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
