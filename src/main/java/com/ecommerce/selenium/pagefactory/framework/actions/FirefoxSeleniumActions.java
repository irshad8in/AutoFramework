package com.ecommerce.selenium.pagefactory.framework.actions;

import com.ecommerce.selenium.pagefactory.framework.browser.web.FirefoxBrowser;

/**
 * Selenium Actions for Firefox Browser.
 *
 * Currently, this is the same as BaseSeleniumActions, as we don't have any need to implement anything differently
 * for Firefox.
 */
public class FirefoxSeleniumActions extends BaseSeleniumActions<FirefoxBrowser> {
    public FirefoxSeleniumActions(FirefoxBrowser browser) {
        super(browser);
    }
}
