
package org.ccwdata.pojo.json;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
    "minConceptItem",
    "sourceConceptItem"
})
public class InteractionConcept {

    @JsonProperty("minConceptItem")
    private MinConceptItem_ minConceptItem;
    @JsonProperty("sourceConceptItem")
    private SourceConceptItem sourceConceptItem;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The minConceptItem
     */
    @JsonProperty("minConceptItem")
    public MinConceptItem_ getMinConceptItem() {
        return minConceptItem;
    }

    /**
     * 
     * @param minConceptItem
     *     The minConceptItem
     */
    @JsonProperty("minConceptItem")
    public void setMinConceptItem(MinConceptItem_ minConceptItem) {
        this.minConceptItem = minConceptItem;
    }

    /**
     * 
     * @return
     *     The sourceConceptItem
     */
    @JsonProperty("sourceConceptItem")
    public SourceConceptItem getSourceConceptItem() {
        return sourceConceptItem;
    }

    /**
     * 
     * @param sourceConceptItem
     *     The sourceConceptItem
     */
    @JsonProperty("sourceConceptItem")
    public void setSourceConceptItem(SourceConceptItem sourceConceptItem) {
        this.sourceConceptItem = sourceConceptItem;
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
