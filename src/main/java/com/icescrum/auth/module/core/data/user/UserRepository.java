package com.icescrum.auth.module.core.data.user;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> users=new ArrayList<>();

    public static UserRepository getInstance() {
        return new UserRepository();
    }

    User query(UserDefinition userDefinition) {
        for(User candidate:getUsers()){
            if(candidate.equivalent(userDefinition)){
                users.remove(candidate);
                return candidate;
            }
        }
        return null;
    }

    private List<User> getUsers() {
        if(users.size()==0){
            users.add(User.getInstance(UserDefinition.getInstance().withUsername("cstockton").withPassword("P@ssw0rd")));
        }
        return users;
    }
}
