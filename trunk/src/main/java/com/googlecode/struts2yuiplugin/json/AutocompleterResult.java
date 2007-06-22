package com.googlecode.struts2yuiplugin.json;

import java.util.ArrayList;
import java.util.List;

public class AutocompleterResult {
    private List<AutocompleterEntry> results = new ArrayList<AutocompleterEntry>();

    public void add(String key, String value) {
        this.results.add(new AutocompleterEntry(key, value));
    }

    public List<AutocompleterEntry> getResults() {
        return this.results;
    }
}
