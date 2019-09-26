package com.softwareonpurpose.gauntlet.anobject;

public class AParent implements AnObjectCalibratable {
    private final AnObject childObject;

    private AParent(AnObject childObject) {
        this.childObject = childObject;
    }

    public static AParent getInstance(AnObject childObject) {
        return new AParent(childObject);
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

    AnObject getChildObject() {
        return childObject;
    }
}
