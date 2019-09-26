package com.softwareonpurpose.gauntlet.anobject;

public class AParentExpected implements AnObjectCalibratable {
    private final AnObjectExpected childObject;

    private AParentExpected(AnObjectExpected childObject) {
        this.childObject = childObject;
    }

    public static AParentExpected getInstance(AnObjectExpected childObject) {
        return new AParentExpected(childObject);
    }

    @Override
    public String getString() {
        return "parent string";
    }

    @Override
    public Integer getInteger() {
        return 9;
    }

    @Override
    public Boolean getBoolean() {
        return false;
    }

    AnObjectExpected getChildObject() {
        return childObject;
    }
}
