package com.ecommerce.selenium.pagefactory.framework.pages;

import org.openqa.selenium.By;
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
    		System.out.println("Product Added to cart Successfully.");
    	}catch(Exception e) {
    		System.out.println("Product not added to cart : "+e.getMessage());
    		except = "true";
    		Assert.assertEquals(except,true,"Product not added to cart, Reason: "+e.getMessage());		
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