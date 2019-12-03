package com.icescrum.auth.module.core.data.user;

public class User extends UserCalibratable {
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

    public boolean equivalent(UserCalibratable userDefinition) {
        if(userDefinition == null){
            return false;
        }
        if(this.getUsername().equals(userDefinition.getUsername())){
            return true;
        }
        boolean equivalent = isEquivalent(userDefinition.getUsername(), this.getUsername());
        equivalent &= isEquivalent(userDefinition.getPassword(), this.getPassword());
        return equivalent;
    }

    private boolean isEquivalent(String definitionUsername, String thisUsername) {
        return definitionUsername == null || thisUsername.equals(definitionUsername);
    }
}
