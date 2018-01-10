package com.ecommerce.selenium.pagefactory.framework.functions;

import com.ecommerce.selenium.pagefactory.framework.browser.LocalBrowserBuilder;
import com.ecommerce.selenium.pagefactory.framework.browser.MobileBrowserBuilder;
import com.ecommerce.selenium.pagefactory.framework.browser.RemoteBrowserBuilder;
import com.ecommerce.selenium.pagefactory.framework.browser.mobile.MobileBrowser;
import com.ecommerce.selenium.pagefactory.framework.browser.mobile.MobilePlatformName;
import com.ecommerce.selenium.pagefactory.framework.browser.web.WebBrowser;
import com.ecommerce.selenium.pagefactory.framework.browser.web.WebBrowserType;
import com.ecommerce.selenium.pagefactory.framework.config.TimeoutType;
import com.ecommerce.selenium.pagefactory.framework.constants.AppConstants;
import com.ecommerce.selenium.pagefactory.framework.exception.JiveWebDriverException;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Logger;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;
import org.eclipse.jetty.util.log.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.TestNGUtils;
import org.testng.annotations.Test;

/**
 *
 *
 * Basic Functional tests for creating different web browsers.
 */
public class Wrapper implements AppConstants {

    
    public WebBrowser openApplication() throws Exception {
        WebBrowser chromeBrowser = createMinimalChrome();
        
        chromeBrowser.openPageByURL("http://52.207.0.161:8084/ECommerce/");
        //chromeBrowser.openPageByURL("http://google.com");
        
		return chromeBrowser;

        //chromeBrowser.quit();
    }
    
    public WebBrowser openBL_Application() throws Exception {
       // WebBrowser chromeBrowser = testcreateMinimalChrome();
    	WebBrowser chromeBrowser = createMinimalChrome_BL();
    	
        chromeBrowser.openPageByURL("https://52.207.22.180:8080/");
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
        return RemoteBrowserBuilder.getBuilder(WebBrowserType.CHROME, "http://52.207.0.161:8084/ECommerce/", "http://172.31.63.151:4444/wd/hub")
        		//.withWebDriverPath("C:\\Users\\Shahed\\Downloads\\chromedriver_win32\\chromedriver.exe")
        		.withWebDriverPath("C:\\selenium\\chromedriver.exe")
        	
                .build();
    }
    
    private WebBrowser createMinimalChrome_BL() throws JiveWebDriverException {
        return RemoteBrowserBuilder.getBuilder(WebBrowserType.CHROME, "https://52.207.22.180:8080/", "http://172.31.63.151:4444/wd/hub")
        		//.withWebDriverPath("C:\\Users\\Shahed\\Downloads\\chromedriver_win32\\chromedriver.exe")
        		.withWebDriverPath("C:\\selenium\\chromedriver.exe")
        	
                .build();
    }
    
    private WebBrowser testcreateMinimalChrome() throws JiveWebDriverException {
        return LocalBrowserBuilder.getBuilder(WebBrowserType.CHROME, "https://52.207.22.180:8080/")
        		.withWebDriverPath("C:\\Users\\Shahed\\Downloads\\chromedriver_win32\\chromedriver.exe")
        		//.withWebDriverPath("C:\\selenium\\chromedriver.exe")
        	
                .build();
    }
    
    public static AppiumDriver getAppiumDriver(String OSVersion,String deviceModel,String platform,String persona ) throws IOException {

    	AppiumDriver driver = null;
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("user", PERFECTO_USRNAME);
		capabilities.setCapability("password", PERFECTO_PWD);
		capabilities.setCapability("platformName", platform);
		capabilities.setCapability("platformVersion", OSVersion);
		capabilities.setCapability("model", deviceModel);
		
		capabilities.setCapability("automationName", "appium");
		
		
		// One liner to set persona
		capabilities.setCapability("windTunnelPersona", persona);
		
		//Creating Android Driver
		try {
			driver = new IOSDriver(
					new URL("https://"+PERFECTO_URL + "/nexperience/perfectomobile/wd/hub"),capabilities);
		} catch (Exception e) {
			String ErrToRep = e.getMessage().substring(0, e.getMessage().indexOf("Command duration") - 1);
			System.out.println(ErrToRep);
			return (null);
		}
		return driver;
	}
    
    public boolean waitForElement(WebDriver app,By objPath) throws Exception{
		try{
			WebDriverWait wait = new WebDriverWait(app, 30);
    		wait.until(ExpectedConditions.visibilityOfElementLocated(objPath));
    		return true;
		}
		catch(Exception e){
			Reporter.log("Error occured on waiting for the element to appear  - "+ e);
			app.quit();
			throw new Exception ("Error occured on waiting for the element to appear  - "+ e);
			
            
		}
	}
    
    
    
   
    
}
