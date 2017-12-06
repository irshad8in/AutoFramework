package com.ecommerce.selenium.pagefactory.framework;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.ecommerce.selenium.pagefactory.framework.browser.web.WebBrowser;
import com.ecommerce.selenium.pagefactory.framework.functions.Wrapper;
import com.ecommerce.selenium.pagefactory.framework.pages.ConfirmOrderPage;
import com.ecommerce.selenium.pagefactory.framework.pages.HomePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;

@Listeners(com.ecommerce.selenium.pagefactory.framework.functions.TestNG_Listener.class)

public class OrderFlow_Mobile extends Wrapper {
	Wrapper wp = new Wrapper();
	private AppiumDriver driver;
	
	@Parameters({ "mobileOS","OSVersion","deviceModel","persona"})
	public void Addtocart_mob(String mobileOS,String OSVersion,String deviceModel,String persona)throws IOException {
		driver = wp.getAppiumDriver(OSVersion,deviceModel, mobileOS,persona);
		driver.get(APP_URL);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}
}
