package com.softwareonpurpose.gauntlet.anobject;

public class AnObject implements AnObjectCalibratable{
    public static AnObject getInstance() {
        return new AnObject();
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
