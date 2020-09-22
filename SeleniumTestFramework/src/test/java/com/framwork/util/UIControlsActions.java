package com.framwork.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UIControlsActions {
	
	WebDriver driver;
	
	
	public UIControlsActions(WebDriver driver) {
		
		
		this.driver=driver;
		
	}
	
	
	public void switchToAlert() {
		
		driver.switchTo().alert();
		
	}
	
	public void alertAccept() {
		
		driver.switchTo().alert().accept();
	}
	
	public boolean isElementDispalayed(By locator) {
		
		boolean result = driver.findElement(locator).isDisplayed();
		
		return result;
		
	}
	
	
	
	

}
