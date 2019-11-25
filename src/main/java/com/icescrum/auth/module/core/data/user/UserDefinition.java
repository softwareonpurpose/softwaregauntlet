package com.icescrum.auth.module.core.data.user;

public class UserDefinition extends UserCalibratable {
    private String username;
    private String password;

    public static UserDefinition getInstance() {
        return new UserDefinition();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    UserDefinition withUsername(String username) {
        this.username = username;
        return this;
    }

    UserDefinition withPassword(String password) {
        this.password = password;
        return this;
    }
}
