package com.icescrum.view.myaccount;

import com.icescrum.view.myaccount.menu.MyAccountMenuExpected;

public class MyAccountViewExpected implements MyAccountViewCalibratable {
    public static MyAccountViewExpected getInstance() {
        return new MyAccountViewExpected();
    }

    @Override
    public MyAccountMenuExpected inMyAccountMenu() {
        return MyAccountMenuExpected.getInstance();
    }
}
