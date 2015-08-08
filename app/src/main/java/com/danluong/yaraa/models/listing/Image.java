
package com.danluong.yaraa.models.listing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Image {

    private Source source;
    private List<Resolution> resolutions = new ArrayList<Resolution>();
    private Variants variants;
    private String id;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The source
     */
    public Source getSource() {
        return source;
    }

    /**
     * 
     * @param source
     *     The source
     */
    public void setSource(Source source) {
        this.source = source;
    }

    /**
     * 
     * @return
     *     The resolutions
     */
    public List<Resolution> getResolutions() {
        return resolutions;
    }

    /**
     * 
     * @param resolutions
     *     The resolutions
     */
    public void setResolutions(List<Resolution> resolutions) {
        this.resolutions = resolutions;
    }

    /**
     * 
     * @return
     *     The variants
     */
    public Variants getVariants() {
        return variants;
    }

    /**
     * 
     * @param variants
     *     The variants
     */
    public void setVariants(Variants variants) {
        this.variants = variants;
    }

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
