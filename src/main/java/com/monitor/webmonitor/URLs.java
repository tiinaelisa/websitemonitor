package com.monitor.webmonitor;

public class URLs {

    private String url;
    private String contentRequirement;
    private long statusCode;
    private boolean isFoundContentAMatch;
    private String statusInfo = "";
    private String contentInfo = "";
 //   private long serverTime;

    public URLs() {}

    public URLs(String url, String contentRequirement) {
        this.url = url;
        this.contentRequirement = contentRequirement;
    }

    public URLs(String url, String contentRequirement, long statusCode, boolean isFoundContentAMatch, String statusInfo, String contentInfo) {
        this.url = url;
        this.contentRequirement = contentRequirement;
        this.statusCode = statusCode;
        this.isFoundContentAMatch = isFoundContentAMatch;
        this.statusInfo = statusInfo;
        this.contentInfo = contentInfo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContentRequirement() {
        return contentRequirement;
    }

    public void setContentRequirement(String contentRequirement) {
        this.contentRequirement = contentRequirement;
    }

    public long getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(long statusCode) {
        this.statusCode = statusCode;
    }

    public boolean isFoundContentAMatch() {
        return isFoundContentAMatch;
    }

    public void setFoundContentAMatch(boolean foundContentAMatch) {
        isFoundContentAMatch = foundContentAMatch;
    }

    public String getStatusInfo() {
        return statusInfo;
    }

    public void setStatusInfo(String statusInfo) {
        this.statusInfo = statusInfo;
    }

    public String getContentInfo() {
        return contentInfo;
    }

    public void setContentInfo(String contentInfo) {
        this.contentInfo = contentInfo;
    }

    @Override
    public String toString() {
        return "URL: " + url + ".\nContent requirement: " + contentRequirement + ".\nStatus code: " + statusCode +
                ".\nFound content matches content requirement: " + isFoundContentAMatch + ".\nStatus information: " +
                statusInfo + ".\nContent information: " + contentInfo + ".\n";
    }
}
