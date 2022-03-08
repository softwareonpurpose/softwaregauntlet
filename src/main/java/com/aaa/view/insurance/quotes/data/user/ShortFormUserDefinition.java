package com.aaa.view.insurance.quotes.data.user;

public class ShortFormUserDefinition implements ShortFormUserCalibratable {
    private String zipCode;
    private boolean isCurrentlyInsured;
    private String type;

    public static ShortFormUserDefinition getInstance() {
        return new ShortFormUserDefinition();
    }

    public ShortFormUserDefinition withZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public boolean isCurrentlyInsured() {
        return isCurrentlyInsured;
    }

    @Override
    public String getZipCode() {
        return null;
    }

    public ShortFormUserDefinition withType(String type) {
        this.type = type;
        return this;
    }

    public ShortFormUserDefinition withIsCurrentlyInsured(boolean isCurrentlyInsured) {
        this.isCurrentlyInsured = isCurrentlyInsured;
        return this;
    }
}
