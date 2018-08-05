package com.wozipa.www.project.yhplan.enums;

/**
 * Created by wozipa on 18-7-1.
 */
public enum MoneyUnit {

    YUAN("yuan"),
    JIAO("jiao"),
    FEN("fen"),
    LI("li");

    private String value = null;

    private MoneyUnit(String val) {
        this.value = val;
    }

    public String getValue(){
        return this.value;
    }
}
