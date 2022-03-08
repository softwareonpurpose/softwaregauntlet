package com.aaa.view.insurance.quotes.data.user;

public class ShortFormUser implements ShortFormUserCalibratable {
    private final ShortFormUserDefinition userDefinition;

    private ShortFormUser(ShortFormUserDefinition userDefinition) {
        this.userDefinition = userDefinition;
    }

    public static ShortFormUser getInstance(ShortFormUserDefinition userDefinition) {
        return new ShortFormUser(userDefinition);
    }

    @Override
    public String getType() {
        return userDefinition.getType();
    }

    @Override
    public boolean isCurrentlyInsured() {
        return userDefinition.isCurrentlyInsured();
    }

    @Override
    public String getZipCode() {
        return userDefinition.getZipCode();
    }
}
