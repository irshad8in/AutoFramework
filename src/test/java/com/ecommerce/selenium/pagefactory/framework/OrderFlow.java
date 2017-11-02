package com.ecommerce.selenium.pagefactory.framework;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
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
	public WebBrowser app;
	
	
	@BeforeTest
	public void Openapp() throws Exception {
    	app = openApplication();
    	Thread.sleep(3000);
    	
    }
		@BeforeMethod   
	    public void Login() throws Exception {
	    	wp.login(app);
			Thread.sleep(3000);
			
		}
			   
		    @Test(priority=1)
			public void Addtocart() throws Exception {
		    	
				hp.Addtocart(app);
				Thread.sleep(3000);
				
			}
			
		    @Test(priority=2)
			public void Checkoutcart() throws Exception {
		    	Addtocart();
				hp.Checkoutcart(app);
				Thread.sleep(3000);
				
			}
			
		    @Test(priority=3)
			public void placeorder() throws Exception {
		    	Checkoutcart();
				cop.PlaceOrder(app);
				Thread.sleep(3000);
				
			}
		@AfterMethod
		public void Logout() throws Exception {
	    	hp.Logout(app);
		}
	@AfterTest
	public void Closeapp() throws Exception {
    	app.quit();
	}
		
   
    	
    	
    	
    	
    	
    	
    	
 }

	