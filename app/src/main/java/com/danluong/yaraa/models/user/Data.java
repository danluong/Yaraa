
package com.danluong.yaraa.models.user;

import java.util.HashMap;
import java.util.Map;


public class Data {

    private boolean hasMail;
    private String name;
    private boolean isFriend;
    private double created;
    private boolean hideFromRobots;
    private int goldCreddits;
    private String modhash;
    private double createdUtc;
    private boolean hasModMail;
    private int linkKarma;
    private int commentKarma;
    private boolean over18;
    private boolean isGold;
    private boolean isMod;
    private Object goldExpiration;
    private boolean hasVerifiedEmail;
    private String id;
    private int inboxCount;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The hasMail
     */
    public boolean isHasMail() {
        return hasMail;
    }

    /**
     * 
     * @param hasMail
     *     The has_mail
     */
    public void setHasMail(boolean hasMail) {
        this.hasMail = hasMail;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The isFriend
     */
    public boolean isIsFriend() {
        return isFriend;
    }

    /**
     * 
     * @param isFriend
     *     The is_friend
     */
    public void setIsFriend(boolean isFriend) {
        this.isFriend = isFriend;
    }

    /**
     * 
     * @return
     *     The created
     */
    public double getCreated() {
        return created;
    }

    /**
     * 
     * @param created
     *     The created
     */
    public void setCreated(double created) {
        this.created = created;
    }

    /**
     * 
     * @return
     *     The hideFromRobots
     */
    public boolean isHideFromRobots() {
        return hideFromRobots;
    }

    /**
     * 
     * @param hideFromRobots
     *     The hide_from_robots
     */
    public void setHideFromRobots(boolean hideFromRobots) {
        this.hideFromRobots = hideFromRobots;
    }

    /**
     * 
     * @return
     *     The goldCreddits
     */
    public int getGoldCreddits() {
        return goldCreddits;
    }

    /**
     * 
     * @param goldCreddits
     *     The gold_creddits
     */
    public void setGoldCreddits(int goldCreddits) {
        this.goldCreddits = goldCreddits;
    }

    /**
     * 
     * @return
     *     The modhash
     */
    public String getModhash() {
        return modhash;
    }

    /**
     * 
     * @param modhash
     *     The modhash
     */
    public void setModhash(String modhash) {
        this.modhash = modhash;
    }

    /**
     * 
     * @return
     *     The createdUtc
     */
    public double getCreatedUtc() {
        return createdUtc;
    }

    /**
     * 
     * @param createdUtc
     *     The created_utc
     */
    public void setCreatedUtc(double createdUtc) {
        this.createdUtc = createdUtc;
    }

    /**
     * 
     * @return
     *     The hasModMail
     */
    public boolean isHasModMail() {
        return hasModMail;
    }

    /**
     * 
     * @param hasModMail
     *     The has_mod_mail
     */
    public void setHasModMail(boolean hasModMail) {
        this.hasModMail = hasModMail;
    }

    /**
     * 
     * @return
     *     The linkKarma
     */
    public int getLinkKarma() {
        return linkKarma;
    }

    /**
     * 
     * @param linkKarma
     *     The link_karma
     */
    public void setLinkKarma(int linkKarma) {
        this.linkKarma = linkKarma;
    }

    /**
     * 
     * @return
     *     The commentKarma
     */
    public int getCommentKarma() {
        return commentKarma;
    }

    /**
     * 
     * @param commentKarma
     *     The comment_karma
     */
    public void setCommentKarma(int commentKarma) {
        this.commentKarma = commentKarma;
    }

    /**
     * 
     * @return
     *     The over18
     */
    public boolean isOver18() {
        return over18;
    }

    /**
     * 
     * @param over18
     *     The over_18
     */
    public void setOver18(boolean over18) {
        this.over18 = over18;
    }

    /**
     * 
     * @return
     *     The isGold
     */
    public boolean isIsGold() {
        return isGold;
    }

    /**
     * 
     * @param isGold
     *     The is_gold
     */
    public void setIsGold(boolean isGold) {
        this.isGold = isGold;
    }

    /**
     * 
     * @return
     *     The isMod
     */
    public boolean isIsMod() {
        return isMod;
    }

    /**
     * 
     * @param isMod
     *     The is_mod
     */
    public void setIsMod(boolean isMod) {
        this.isMod = isMod;
    }

    /**
     * 
     * @return
     *     The goldExpiration
     */
    public Object getGoldExpiration() {
        return goldExpiration;
    }

    /**
     * 
     * @param goldExpiration
     *     The gold_expiration
     */
    public void setGoldExpiration(Object goldExpiration) {
        this.goldExpiration = goldExpiration;
    }

    /**
     * 
     * @return
     *     The hasVerifiedEmail
     */
    public boolean isHasVerifiedEmail() {
        return hasVerifiedEmail;
    }

    /**
     * 
     * @param hasVerifiedEmail
     *     The has_verified_email
     */
    public void setHasVerifiedEmail(boolean hasVerifiedEmail) {
        this.hasVerifiedEmail = hasVerifiedEmail;
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

    /**
     * 
     * @return
     *     The inboxCount
     */
    public int getInboxCount() {
        return inboxCount;
    }

    /**
     * 
     * @param inboxCount
     *     The inbox_count
     */
    public void setInboxCount(int inboxCount) {
        this.inboxCount = inboxCount;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
