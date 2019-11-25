package com.icescrum.auth.module.core.data.user;

public class UserRepository {
    public static UserRepository getInstance() {
        return new UserRepository();
    }

    User get(UserDefinition userDefinition) {
        return User.getInstance(userDefinition.withUsername("cstockton").withPassword("P@ssw0rd"));
    }
}
