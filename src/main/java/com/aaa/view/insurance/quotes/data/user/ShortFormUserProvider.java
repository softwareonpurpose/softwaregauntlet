package com.aaa.view.insurance.quotes.data.user;

public class ShortFormUserProvider {
    private ShortFormUserProvider() {
    }

    public static ShortFormUserProvider getInstance() {
        return new ShortFormUserProvider();
    }

    public ShortFormUser get(ShortFormUserDefinition userDefinition) {
        return ShortFormUserRepository.getInstance().query(userDefinition);
    }
}
