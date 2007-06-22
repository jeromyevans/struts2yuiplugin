package com.googlecode.struts2yuiplugin.json;

public class AutocompleterEntry {
    private String value;
    private String key;

    public AutocompleterEntry(String key, String value) {
        this.value = value;
        this.key = key;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
