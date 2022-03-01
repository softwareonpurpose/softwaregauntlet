package com.aaa.view.insurance.quotes.shortform.ziprouter;

public class ZipRouterViewExpected implements ZipRouterViewCalibratable {
    private final String zipCode;

    private ZipRouterViewExpected(String zipCode) {
        this.zipCode = zipCode;
    }

    public static ZipRouterViewExpected getInstance() {
        return new ZipRouterViewExpected(null);
    }

    public static ZipRouterViewExpected getInstance(String zipCode) {
        return new ZipRouterViewExpected(zipCode);
    }

    @Override
    public Boolean isGoButtonEnabled() {
        return zipCode != null && zipCode.length() == 5;
    }
}
