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
//    "nlmDisclaimer",
//    "userInput",
//    "interactionTypeGroup"
//})
//public class Interaction {
//
//    @JsonProperty("nlmDisclaimer")
//    private String nlmDisclaimer;
//    @JsonProperty("userInput")
//    private UserInput userInput;
//    @JsonProperty("interactionTypeGroup")
//    private List<InteractionTypeGroup> interactionTypeGroup = new ArrayList<InteractionTypeGroup>();
//    @JsonIgnore
//    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
//
//    private String drugName;
//
//    /**
//     * 
//     * @return
//     *     The nlmDisclaimer
//     */
//    @JsonProperty("nlmDisclaimer")
//    public String getNlmDisclaimer() {
//        return nlmDisclaimer;
//    }
//
//    /**
//     * 
//     * @param nlmDisclaimer
//     *     The nlmDisclaimer
//     */
//    @JsonProperty("nlmDisclaimer")
//    public void setNlmDisclaimer(String nlmDisclaimer) {
//        this.nlmDisclaimer = nlmDisclaimer;
//    }
//
//    /**
//     * 
//     * @return
//     *     The userInput
//     */
//    @JsonProperty("userInput")
//    public UserInput getUserInput() {
//        return userInput;
//    }
//
//    /**
//     * 
//     * @param userInput
//     *     The userInput
//     */
//    @JsonProperty("userInput")
//    public void setUserInput(UserInput userInput) {
//        this.userInput = userInput;
//    }
//
//    /**
//     * 
//     * @return
//     *     The interactionTypeGroup
//     */
//    @JsonProperty("interactionTypeGroup")
//    public List<InteractionTypeGroup> getInteractionTypeGroup() {
//        return interactionTypeGroup;
//    }
//
//    /**
//     * 
//     * @param interactionTypeGroup
//     *     The interactionTypeGroup
//     */
//    @JsonProperty("interactionTypeGroup")
//    public void setInteractionTypeGroup(List<InteractionTypeGroup> interactionTypeGroup) {
//        this.interactionTypeGroup = interactionTypeGroup;
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
//	public String getDrugName() {
//		return drugName;
//	}
//
//	public void setDrugName(String drugName) {
//		this.drugName = drugName;
//	}
//}
