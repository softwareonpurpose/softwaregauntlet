package com.aaa.view.insurance.quotes.data.user;

public class ShortFormUserRepository {
    public static ShortFormUserRepository getInstance() {
        return new ShortFormUserRepository();
    }

    public ShortFormUser query(ShortFormUserDefinition userDefinition) {
        return ShortFormUser.getInstance(userDefinition);
    }
}
