package com.ecommerce.selenium.pagefactory.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ecommerce.selenium.pagefactory.framework.browser.web.WebBrowser;
import com.ecommerce.selenium.pagefactory.framework.config.TimeoutType;


public class HomePage  {
	String except = "false";
	
    public void Addtocart(WebBrowser app) throws Exception {
    	try {
    		app.getActions().click(By.xpath("//table/tbody/tr/td[text()='Youth watches']/following-sibling::td/input[@id='viewdetail']"), TimeoutType.DEFAULT);
    		System.out.println("Clicked Add to cart button Successfully.");
    	}catch(Exception e) {
    		System.out.println("Unable to click add to cart button : "+e.getMessage());
    		except = "true";
    		Assert.assertEquals(except,true,"Unable to click add to cart button, Reason: "+e.getMessage());	
    	}
    	try {
    		app.getActions().verifyElementVisible(By.xpath("//font[contains(text(), 'cart successfully')]"), TimeoutType.DEFAULT);
    		System.out.println("Product added to cart Successfully.");
    	}catch(Exception e) {
    		System.out.println("Unable to add product to cart : "+e.getMessage());
    		except = "true";
    		Assert.assertEquals(except,true,"Unable to add product to cart, Reason: "+e.getMessage());	
    	}
    	
    }
    
    public void Addtocart_BL(WebBrowser app) throws Exception {
    	try {
    		app.getActions().click(By.xpath("//a[text()='Day of the Dead Scotch Bonnet Hot Sauce']"), TimeoutType.DEFAULT);
    		System.out.println("Clicked product successfully.");
    	}catch(Exception e) {
    		System.out.println("Unable to click product : "+e.getMessage());
    		except = "true";
    		Assert.assertEquals(except,true,"Unable to click product, Reason: "+e.getMessage());	
    	}
    	
    	try {
    		app.getActions().click(By.xpath("//button[@class='btn btn-primary js-addToCart']"), TimeoutType.DEFAULT);
    		System.out.println("Clicked Add to cart button Successfully.");
    	}catch(Exception e) {
    		System.out.println("Unable to click add to cart button : "+e.getMessage());
    		except = "true";
    		Assert.assertEquals(except,true,"Unable to click add to cart button, Reason: "+e.getMessage());	
    	}
    	try {
    		app.getActions().verifyElementVisible(By.xpath("//a[text()='View in Cart']"), TimeoutType.DEFAULT);
    		System.out.println("Product added to cart Successfully.");
    	}catch(Exception e) {
    		System.out.println("Unable to add product to cart : "+e.getMessage());
    		except = "true";
    		Assert.assertEquals(except,true,"Unable to add product to cart, Reason: "+e.getMessage());	
    	}
    	
    	
    }
    
    public void Checkoutcart(WebBrowser app) throws Exception {
    	try {
    		app.getActions().click(By.id("checkoutproduct"), TimeoutType.DEFAULT);
    		System.out.println("Clicked Checkout product button Successfully.");
    	}catch(Exception e) {
    		System.out.println("Unable to click Checkout product button : "+e.getMessage());
    		except = "true";
    		Assert.assertEquals(except,true,"Unable to click Checkout product button, Reason: "+e.getMessage());		
    	}
    	
    }
    
    public void Checkoutcart_BL(WebBrowser app) throws Exception {
    	try {
    		app.getActions().click(By.xpath("//a[text()='View in Cart']"), TimeoutType.DEFAULT);
    		System.out.println("Clicked View Cart button Successfully.");
    	}catch(Exception e) {
    		System.out.println("Unable to click View Cart button : "+e.getMessage());
    		except = "true";
    		Assert.assertEquals(except,true,"Unable to click View Cart button, Reason: "+e.getMessage());		
    	}
    	try {
    		app.getActions().click(By.xpath("//span[text()='Checkout']"), TimeoutType.DEFAULT);
    		System.out.println("Clicked Checkout product button Successfully.");
    	}catch(Exception e) {
    		System.out.println("Unable to click Checkout product button : "+e.getMessage());
    		except = "true";
    		Assert.assertEquals(except,true,"Unable to click Checkout product button, Reason: "+e.getMessage());		
    	}
    	try {
    		WebDriver driver=app.getWebDriver();
    		String url=driver.getCurrentUrl();
    		if(url.contains("login")) {
    			app.getActions().click(By.xpath("//button[text()='Checkout as Guest']"), TimeoutType.DEFAULT);
    		}
    		app.getActions().verifyElementVisible(By.xpath("//h1[text()='Checkout']"), TimeoutType.DEFAULT);
    		System.out.println("Checkout screen loaded sucessfully");
    	}catch(Exception e) {
    		System.out.println("checkout screen not loaded : "+e.getMessage());
    		except = "true";
    		Assert.assertEquals(except,true,"checkout screen not loaded, Reason: "+e.getMessage());		
    	}
    	
    }
    
  
    public void Logout(WebBrowser app) throws Exception {
    	try {
    		app.getActions().click(By.linkText("Logout"), TimeoutType.DEFAULT);
    		System.out.println("Clicked Logout link Successfully.");
    	}catch(Exception e) {
    		System.out.println("Unable to click Logout link : "+e.getMessage());
    		except = "true";
    		Assert.assertEquals(except,true,"Unable to click Logout link, Reason: "+e.getMessage());		
    	}
    	
    }
    
    
}