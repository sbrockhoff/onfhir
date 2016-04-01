
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
    "interactionConcept",
    "severity",
    "description"
})
public class InteractionPair {

    @JsonProperty("interactionConcept")
    private List<InteractionConcept> interactionConcept = new ArrayList<InteractionConcept>();
    @JsonProperty("severity")
    private String severity;
    @JsonProperty("description")
    private String description;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The interactionConcept
     */
    @JsonProperty("interactionConcept")
    public List<InteractionConcept> getInteractionConcept() {
        return interactionConcept;
    }

    /**
     * 
     * @param interactionConcept
     *     The interactionConcept
     */
    @JsonProperty("interactionConcept")
    public void setInteractionConcept(List<InteractionConcept> interactionConcept) {
        this.interactionConcept = interactionConcept;
    }

    /**
     * 
     * @return
     *     The severity
     */
    @JsonProperty("severity")
    public String getSeverity() {
        return severity;
    }

    /**
     * 
     * @param severity
     *     The severity
     */
    @JsonProperty("severity")
    public void setSeverity(String severity) {
        this.severity = severity;
    }

    /**
     * 
     * @return
     *     The description
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
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
