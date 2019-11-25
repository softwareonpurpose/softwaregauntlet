package com.icescrum.auth.module.core.data.user;

public class User implements UserCalibratable {
    private final UserDefinition mockUser;

    private User(UserDefinition userDefinition) {
        mockUser = userDefinition;
    }

    public static User getInstance(UserDefinition userDefinition) {
        return new User(userDefinition);
    }

    @Override
    public String getPassword() {
        return mockUser.getPassword();
    }

    @Override
    public String getUsername() {
        return mockUser.getUsername();
    }
}
