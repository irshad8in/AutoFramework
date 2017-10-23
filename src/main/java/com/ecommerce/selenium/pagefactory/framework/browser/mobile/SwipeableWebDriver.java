package com.ecommerce.selenium.pagefactory.framework.browser.mobile;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.interactions.HasTouchScreen;
import org.openqa.selenium.interactions.TouchScreen;
import org.openqa.selenium.remote.RemoteTouchScreen;

import java.net.URL;

/**
 * Created by amir on 11/18/14.
 */
public class SwipeableWebDriver extends AndroidDriver implements HasTouchScreen {
    private RemoteTouchScreen touch;

    public SwipeableWebDriver(URL remoteAddress, Capabilities desiredCapabilities) {
        super(remoteAddress, desiredCapabilities);
        touch = new RemoteTouchScreen(getExecuteMethod());
    }

    @Override
    public TouchScreen getTouch() {
        return touch;
    }

    @Override
    public MobileElement scrollTo(String s) {
        return null;
    }

    @Override
    public MobileElement scrollToExact(String s) {
        return null;
    }
}
