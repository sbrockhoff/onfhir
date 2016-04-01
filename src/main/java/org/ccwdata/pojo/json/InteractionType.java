
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
    "comment",
    "minConceptItem",
    "interactionPair"
})
public class InteractionType {

    @JsonProperty("comment")
    private String comment;
    @JsonProperty("minConceptItem")
    private MinConceptItem minConceptItem;
    @JsonProperty("interactionPair")
    private List<InteractionPair> interactionPair = new ArrayList<InteractionPair>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The comment
     */
    @JsonProperty("comment")
    public String getComment() {
        return comment;
    }

    /**
     * 
     * @param comment
     *     The comment
     */
    @JsonProperty("comment")
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * 
     * @return
     *     The minConceptItem
     */
    @JsonProperty("minConceptItem")
    public MinConceptItem getMinConceptItem() {
        return minConceptItem;
    }

    /**
     * 
     * @param minConceptItem
     *     The minConceptItem
     */
    @JsonProperty("minConceptItem")
    public void setMinConceptItem(MinConceptItem minConceptItem) {
        this.minConceptItem = minConceptItem;
    }

    /**
     * 
     * @return
     *     The interactionPair
     */
    @JsonProperty("interactionPair")
    public List<InteractionPair> getInteractionPair() {
        return interactionPair;
    }

    /**
     * 
     * @param interactionPair
     *     The interactionPair
     */
    @JsonProperty("interactionPair")
    public void setInteractionPair(List<InteractionPair> interactionPair) {
        this.interactionPair = interactionPair;
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
