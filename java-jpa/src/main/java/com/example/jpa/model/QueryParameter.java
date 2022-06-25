package com.example.jpa.model;

import java.util.HashMap;
import java.util.Map;

/*
    Create by Atiye Mousavi 
    Date: 6/18/2022
    Time: 3:17 PM
**/
public class QueryParameter {
    private Map<String, Object> parameters = null;

    private QueryParameter(final String name, final Object value) {
        this.parameters = new HashMap<>();
        this.parameters.put(name, value);
    }

    public static QueryParameter with(final String name, final Object value) {
        return new QueryParameter(name, value);
    }

    public QueryParameter and(final String name, final Object value) {
        this.parameters.put(name, value);
        return this;
    }

    public Map<String, Object> parameters() {
        return this.parameters;
    }

}
