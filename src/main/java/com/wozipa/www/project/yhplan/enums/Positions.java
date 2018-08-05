package com.wozipa.www.project.yhplan.enums;

/**
 * Created by wozipa on 18-7-1.
 */
public enum Positions {

    FrontThree("frontThreee"),
    MiddleThree("middleThree"),
    BehindThree("behindThree");


    private String _value;

    private Positions(String value) {
        this._value = value;
    }

    public String getValue(){
        return this._value;
    }
}
