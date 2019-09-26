package com.softwareonpurpose.gauntlet.anobject;

public class AnObjectExpected implements AnObjectCalibratable{
    public static AnObjectExpected getInstance() {
        return new AnObjectExpected();
    }

    @Override
    public String getString() {
        return "Sample string";
    }

    @Override
    public Integer getInteger() {
        return 5;
    }

    @Override
    public Boolean getBoolean() {
        return true;
    }
}
