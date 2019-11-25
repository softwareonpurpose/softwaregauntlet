package com.icescrum.auth.module.core.data.user;

import com.google.gson.Gson;

abstract class UserCalibratable {
    abstract String getPassword();

    abstract String getUsername();

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
