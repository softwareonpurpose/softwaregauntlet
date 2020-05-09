/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hmhco;

import com.softwareonpurpose.gauntlet.Environment;
import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;

/**
 * @author Frederick Bloom
 */
public class Home extends UiView implements HomeCalibratable {

    private static final String VIEW_URI = Environment.getInstance().getDomainUrl();
    private static final String DESCRIPTION = "homeview";
    private static final String LOCATOR_TYPE = UiLocatorType.CLASS;
    private static final String LOCATOR_VALUE = "page-blog";

    public Home() {
        super(VIEW_URI, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    public static Home directNav() {
        Home view = new Home();
        view.load();
        return UiView.expect(Home.class);
    }

    @Override
    protected boolean confirmElementStates() {
        return getElement().isDisplayed();
    }

}
