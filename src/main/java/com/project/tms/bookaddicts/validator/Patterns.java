package com.project.tms.bookaddicts.validator;

public enum Patterns {

    EMAIL_PATTERN("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
             "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"),

    NAME_PATTERN("^[A-Z]{1}[a-z]+$"),

    NUMBER_PATTERN("^[1-9]{1}[0-9]{0,}"),

    LINK_PATTERN("href=[\\\"']?(.*)[\\\"']?\\s");



    private final String pattern;
    Patterns(String pattern){
        this.pattern = pattern;
    }

    public String getPattern(){
        return pattern;
    }
}
