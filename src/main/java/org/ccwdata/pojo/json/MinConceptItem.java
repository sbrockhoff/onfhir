//
//package org.ccwdata.pojo.json;
//
//import java.util.HashMap;
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
//    "rxcui",
//    "name",
//    "tty"
//})
//public class MinConceptItem {
//
//    @JsonProperty("rxcui")
//    private String rxcui;
//    @JsonProperty("name")
//    private String name;
//    @JsonProperty("tty")
//    private String tty;
//    @JsonIgnore
//    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
//
//    /**
//     * 
//     * @return
//     *     The rxcui
//     */
//    @JsonProperty("rxcui")
//    public String getRxcui() {
//        return rxcui;
//    }
//
//    /**
//     * 
//     * @param rxcui
//     *     The rxcui
//     */
//    @JsonProperty("rxcui")
//    public void setRxcui(String rxcui) {
//        this.rxcui = rxcui;
//    }
//
//    /**
//     * 
//     * @return
//     *     The name
//     */
//    @JsonProperty("name")
//    public String getName() {
//        return name;
//    }
//
//    /**
//     * 
//     * @param name
//     *     The name
//     */
//    @JsonProperty("name")
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    /**
//     * 
//     * @return
//     *     The tty
//     */
//    @JsonProperty("tty")
//    public String getTty() {
//        return tty;
//    }
//
//    /**
//     * 
//     * @param tty
//     *     The tty
//     */
//    @JsonProperty("tty")
//    public void setTty(String tty) {
//        this.tty = tty;
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
