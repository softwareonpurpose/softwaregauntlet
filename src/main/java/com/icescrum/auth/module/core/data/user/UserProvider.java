package com.icescrum.auth.module.core.data.user;

public class UserProvider {
    public static UserProvider getInstance() {
        return new UserProvider();
    }

    public User get(UserDefinition userDefinition) {
        return UserRepository.getInstance().query(userDefinition);
    }

    public User get() {
        return get(UserDefinition.getInstance());
    }
}
