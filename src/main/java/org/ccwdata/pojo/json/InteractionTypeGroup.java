//
//package org.ccwdata.pojo.json;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.codehaus.jackson.annotate.JsonAnyGetter;
//import org.codehaus.jackson.annotate.JsonAnySetter;
//import org.codehaus.jackson.annotate.JsonIgnore;
//import org.codehaus.jackson.annotate.JsonProperty;
//import org.codehaus.jackson.annotate.JsonPropertyOrder;
//import org.codehaus.jackson.map.annotate.JsonSerialize;
//
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//@JsonPropertyOrder({
//    "sourceDisclaimer",
//    "sourceName",
//    "interactionType"
//})
//public class InteractionTypeGroup {
//
//    @JsonProperty("sourceDisclaimer")
//    private String sourceDisclaimer;
//    @JsonProperty("sourceName")
//    private String sourceName;
//    @JsonProperty("interactionType")
//    private List<InteractionType> interactionType = new ArrayList<InteractionType>();
//    @JsonIgnore
//    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
//
//    /**
//     * 
//     * @return
//     *     The sourceDisclaimer
//     */
//    @JsonProperty("sourceDisclaimer")
//    public String getSourceDisclaimer() {
//        return sourceDisclaimer;
//    }
//
//    /**
//     * 
//     * @param sourceDisclaimer
//     *     The sourceDisclaimer
//     */
//    @JsonProperty("sourceDisclaimer")
//    public void setSourceDisclaimer(String sourceDisclaimer) {
//        this.sourceDisclaimer = sourceDisclaimer;
//    }
//
//    /**
//     * 
//     * @return
//     *     The sourceName
//     */
//    @JsonProperty("sourceName")
//    public String getSourceName() {
//        return sourceName;
//    }
//
//    /**
//     * 
//     * @param sourceName
//     *     The sourceName
//     */
//    @JsonProperty("sourceName")
//    public void setSourceName(String sourceName) {
//        this.sourceName = sourceName;
//    }
//
//    /**
//     * 
//     * @return
//     *     The interactionType
//     */
//    @JsonProperty("interactionType")
//    public List<InteractionType> getInteractionType() {
//        return interactionType;
//    }
//
//    /**
//     * 
//     * @param interactionType
//     *     The interactionType
//     */
//    @JsonProperty("interactionType")
//    public void setInteractionType(List<InteractionType> interactionType) {
//        this.interactionType = interactionType;
//    }
//
//    @JsonAnyGetter
//    public Map<String, Object> getAdditionalProperties() {
//        return this.additionalProperties;
//    }
//
//    @JsonAnySetter
//    public void setAdditionalProperty(String name, Object value) {
//        this.additionalProperties.put(name, value);
//    }
//
//}
