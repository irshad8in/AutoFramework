package com.ecommerce.selenium.pagefactory.framework.pages;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ecommerce.selenium.pagefactory.framework.browser.web.WebBrowser;
import com.ecommerce.selenium.pagefactory.framework.config.TimeoutType;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;


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
    
    public void PlaceOrder_BL(WebBrowser app) throws Exception {
    	try {
    		WebDriver driver = app.getWebDriver();
    		driver.manage().window().maximize();
    		Thread.sleep(2000);
    		app.getActions().click(By.xpath("(//span[@class='circle'])[1]"), TimeoutType.DEFAULT);
    		app.getActions().inputText(By.id("fullName"), "Test");
    		app.getActions().inputText(By.id("addressLine1"), "Test");
    		app.getActions().inputText(By.id("city"), "Test");
    		app.getActions().clickAndSelectFromList(By.id("stateProvinceRegion"), By.xpath("//option[@value='CA']"));
    		app.getActions().inputText(By.id("postalCode"), "90078");
    		app.getActions().inputText(By.id("phonePrimary"), "9007817896");
    		
    		
    		
    	
    		
    		
    		// if the element is on bottom.
    		//js.executeScript("scroll(0, 250)");
    		//WebElement radio = driver.findElement(By.xpath(""));
    	   //((JavascriptExecutor)driver).executeScript("arguments[0].checked=true", radio);
    	  // WebElement element = driver.findElement(By("element_path"));

    	  // Actions actions = new Actions(driver);

    	 //  actions.moveToElement(radio).click().perform();
    		//app.getActions().click(By.xpath("(//*[@id='shippingInfo']/div/div[2]/div[2]/label"), TimeoutType.TEN_SECONDS);
    		/*WebDriver driver = app.getWebDriver();
    		java.util.List<WebElement>  oRadioButton = driver.findElements(By.xpath("//*[@class='radio']"));
    	
    	    System.out.println(oRadioButton.size());
    	    //If u want to select the radio button
    	    //driver.findElement(By.id("fulfillmentOptionId1")).click();
    	    Thread.sleep(3000);
    	    //If u want the Text in U R console
    	    for(int i=0;i<oRadioButton.size();i++){
    	    	
    	    	System.out.println(oRadioButton.get(i).getText());
    	    	if(oRadioButton.get(i).getText().contains("Standard")) {
    	    		oRadioButton.get(i).click();
    	    		break;
    	    	}
    	    } 
    	    //If u want to check whether the radio button is selected or not
    	    if(driver.findElement(By.id("fulfillmentOptionId1")).isSelected()){
    	        System.out.println("True");
    	    }else
    	    {
    	        System.out.println("False");
    	    }*/
    		
    		System.out.println("Input Fields entered Sucessfully");
    	}catch(Exception e) {
    		System.out.println("Unable to input Fields : "+e.getMessage());
    		except = "true";
    		Assert.assertEquals(except,true,"Unable to input Fields, Reason: "+e.getMessage());	
    	}
    	try {
    		app.getActions().click(By.xpath("//span[text()='Continue']"), TimeoutType.DEFAULT);
    		System.out.println("Clicked Continue to payment Sucessfully.");
    	}catch(Exception e) {
    		System.out.println("Unable to click Continue to payment : "+e.getMessage());
    		except = "true";
    		Assert.assertEquals(except,true,"Unable to click Continue to payment, Reason: "+e.getMessage());		
    	}
    	try {
    		app.getActions().click(By.xpath("//a[text()='Collect On Delivery']"), TimeoutType.DEFAULT);
    		System.out.println("clicked COD Sucessfully.");
    	}catch(Exception e) {
    		System.out.println("Not able to select COD : "+e.getMessage());
    		except = "true";
    		Assert.assertEquals(except,true,"Not able to select COD , Reason: "+e.getMessage());		
    	}
    	
    	try {
    		app.getActions().click(By.xpath("//span[text()='Continue']"), TimeoutType.DEFAULT);
    		System.out.println("Clicked Continue to review Sucessfully.");
    	}catch(Exception e) {
    		System.out.println("Unable to click Continue to review : "+e.getMessage());
    		except = "true";
    		Assert.assertEquals(except,true,"Unable to click Continue to review, Reason: "+e.getMessage());		
    	}
    	
    	try {
    		app.getActions().click(By.xpath("//span[text()='Place Your Order'][1]"), TimeoutType.DEFAULT);
    		System.out.println("Clicked Place Your Order Sucessfully.");
    	}catch(Exception e) {
    		System.out.println("Unable to click Place Your Order : "+e.getMessage());
    		except = "true";
    		Assert.assertEquals(except,true,"Unable to click Place Your Order, Reason: "+e.getMessage());		
    	}
    	
    	
    	try {
    		app.getActions().verifyElementVisible(By.xpath("//span[text()='Order Confirmation #']"), TimeoutType.DEFAULT);
    		System.out.println("Order Created Sucessfully.");
    	}catch(Exception e) {
    		System.out.println("Order not created : "+e.getMessage());
    		except = "true";
    		Assert.assertEquals(except,true,"Order not created , Reason: "+e.getMessage());		
    	}
    	
    	
    }
}