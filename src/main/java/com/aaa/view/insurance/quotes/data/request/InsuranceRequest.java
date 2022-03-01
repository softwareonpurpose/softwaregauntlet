package com.aaa.view.insurance.quotes.data.request;

public class InsuranceRequest {
    private final String type;
    private final boolean isCurrentlyInsured;

    private InsuranceRequest(String type, boolean isCurrentlyInsured) {
        this.type = type;
        this.isCurrentlyInsured = isCurrentlyInsured;
    }

    public static InsuranceRequest getInstance(String type, boolean isCurrentlyInsured) {
        return new InsuranceRequest(type, isCurrentlyInsured);
    }

    public String getType() {
        return type;
    }

    public boolean isCurrentlyInsured() {
        return isCurrentlyInsured;
    }
}
