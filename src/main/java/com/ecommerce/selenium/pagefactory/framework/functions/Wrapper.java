package com.ecommerce.selenium.pagefactory.framework.functions;

import com.ecommerce.selenium.pagefactory.framework.browser.LocalBrowserBuilder;
import com.ecommerce.selenium.pagefactory.framework.browser.RemoteBrowserBuilder;
import com.ecommerce.selenium.pagefactory.framework.browser.web.WebBrowser;
import com.ecommerce.selenium.pagefactory.framework.browser.web.WebBrowserType;
import com.ecommerce.selenium.pagefactory.framework.config.TimeoutType;
import com.ecommerce.selenium.pagefactory.framework.exception.JiveWebDriverException;

import java.util.logging.Logger;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;
import org.eclipse.jetty.util.log.Log;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.TestNGUtils;
import org.testng.annotations.Test;

/**
 *
 *
 * Basic Functional tests for creating different web browsers.
 */
public class Wrapper {

    
    public WebBrowser openApplication() throws Exception {
        WebBrowser chromeBrowser = createMinimalChrome();
        
        chromeBrowser.openPageByURL("http://52.207.0.161:8084/ECommerce/");
        //chromeBrowser.openPageByURL("http://google.com");
        
		return chromeBrowser;

        //chromeBrowser.quit();
    }
    
    public void login(WebBrowser app) throws Exception {
        String except = "false";
    	
    	try {
    		app.getActions().verifyElementVisible(By.id("username"), TimeoutType.DEFAULT);
    		System.out.println("Login page loaded Sucessfully");
    	}catch(Exception e){
    		System.out.println("Login page not loaded : "+e.getMessage());
    		except = "true";
    		Assert.assertEquals(except,true,"Login Page is not Loaded, Reason: "+e.getMessage());
    	}
    	try {
	    	app.getActions().inputText(By.id("username"), "karthy@gmail.com");
	    	app.getActions().inputText(By.id("password"), "1234");
	    	System.out.println("Username and possword entered Sucessfully");
    	}catch(Exception e) {
    		System.out.println("Unable to input Username/Password : "+e.getMessage());
    		except = "true";
    		Assert.assertEquals(except,true,"Unable to input Username/Password, Reason: "+e.getMessage());	
    	}
    	try {
    		app.getActions().click(By.className("btsign"), TimeoutType.DEFAULT);
    		System.out.println("Login button clicked Sucessfully");
    	}catch(Exception e) {
    		System.out.println("Unable to click the login button : "+e.getMessage());
    		except = "true";
    		Assert.assertEquals(except,true,"Unable to click the login button, Reason: "+e.getMessage());
    	}
    	try {
    		app.getActions().verifyElementVisible(By.xpath("//a[text()='Logout']"),TimeoutType.DEFAULT);
    		System.out.println("Home page loaded Sucessfully");
    		
    	}catch(Exception e) {
    		System.out.println("Unable to load home page : "+e.getMessage());
    		except = "true";
    		Assert.assertEquals(except,true,"Unable to load home page, Reason: "+e.getMessage());
    	}
    }


    private WebBrowser createMinimalChrome() throws JiveWebDriverException {
        return RemoteBrowserBuilder.getBuilder(WebBrowserType.CHROME, "http://52.207.0.161:8084/ECommerce/", "http://52.90.134.192:4444/wd/hub")
        		//.withWebDriverPath("C:\\Users\\Shahed\\Downloads\\chromedriver_win32\\chromedriver.exe")
        		.withWebDriverPath("C:\\selenium\\chromedriver.exe")
        	
                .build();
    }
}
