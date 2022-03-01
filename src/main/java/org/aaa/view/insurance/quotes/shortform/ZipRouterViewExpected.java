package org.aaa.view.insurance.quotes.shortform;

public class ZipRouterViewExpected implements ZipRouterViewCalibratable {
    private ZipRouterViewExpected() {
    }

    public static ZipRouterViewExpected getInstance() {
        return new ZipRouterViewExpected();
    }

    @Override
    public Boolean isGoButtonEnabled() {
        return false;
    }
}
