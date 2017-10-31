package com.ecommerce.selenium.pagefactory.framework.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.ecommerce.selenium.pagefactory.framework.browser.web.WebBrowser;
import com.ecommerce.selenium.pagefactory.framework.config.TimeoutType;


public class ConfirmOrderPage  {
	String except = "false";
	
    public void PlaceOrder(WebBrowser app) throws Exception {
    	try {
    		app.getActions().inputText(By.id("address1"), "Irving");
    		System.out.println("Address1 entered Sucessfully");
    	}catch(Exception e) {
    		System.out.println("Unable to input Address1 : "+e.getMessage());
    		except = "true";
    		Assert.assertEquals(except,true,"Unable to input Address1, Reason: "+e.getMessage());	
    	}
    	try {
    		app.getActions().click(By.xpath("//input[@value='OneClickPay']"), TimeoutType.DEFAULT);
    		System.out.println("Clicked OneClickPay Sucessfully.");
    	}catch(Exception e) {
    		System.out.println("Unable to clic OneClickPay : "+e.getMessage());
    		except = "true";
    		Assert.assertEquals(except,true,"Unable to clic OneClickPay, Reason: "+e.getMessage());		
    	}
    	try {
    		app.getActions().verifyElementVisible(By.xpath("//font[contains(text(),'Order Created')]"), TimeoutType.DEFAULT);
    		System.out.println("Order Created Sucessfully.");
    	}catch(Exception e) {
    		System.out.println("Order not created : "+e.getMessage());
    		except = "true";
    		Assert.assertEquals(except,true,"Order not created , Reason: "+e.getMessage());		
    	}
    	
    	
    }
}