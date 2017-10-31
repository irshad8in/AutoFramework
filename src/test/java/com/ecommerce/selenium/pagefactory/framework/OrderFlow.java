package com.ecommerce.selenium.pagefactory.framework;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.ecommerce.selenium.pagefactory.framework.browser.web.WebBrowser;
import com.ecommerce.selenium.pagefactory.framework.functions.Wrapper;
import com.ecommerce.selenium.pagefactory.framework.pages.ConfirmOrderPage;
import com.ecommerce.selenium.pagefactory.framework.pages.HomePage;
@Listeners(com.ecommerce.selenium.pagefactory.framework.functions.TestNG_Listener.class)
public class OrderFlow extends Wrapper{
	//public static final String WEB_DRIVER_PATH = System.getProperty("C:\\Users\\Shahed\\Downloads\\chromedriver_win32\\chromedriver.exe");
	Wrapper wp = new Wrapper();
	HomePage hp= new HomePage();
	ConfirmOrderPage cop = new ConfirmOrderPage();
    @Test
    public void PlaceOrder() throws Exception {
    	WebBrowser app = openApplication();
    	wp.login(app);
    	Thread.sleep(3000);
    	hp.Addtocart(app);
    	Thread.sleep(3000);
    	hp.Checkoutcart(app);
    	Thread.sleep(3000);
    	cop.PlaceOrder(app);
    	Thread.sleep(3000);
    	app.quit();
    	
    	
    }

	
}