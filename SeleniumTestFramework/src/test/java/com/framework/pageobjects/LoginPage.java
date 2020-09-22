package com.framework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framwork.util.UIControlsActions;

public class LoginPage {
	
	WebDriver driver;
	
	UIControlsActions action;
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		
		action = new UIControlsActions(driver);
		
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(name="uid")
	WebElement usrName;
	
	
	@FindBy(name="password")
	WebElement passWrd;
	
	
	@FindBy(name="btnLogin")
	WebElement loginBtn;
	
	@FindBy(linkText="Log out")
	WebElement logoutLink;
	
	
	/*
	 * Function		: enterCredentials
	 * Parameters	: username,password
	 * Description	: This method will enter the credentials in login page 
	 * Author		: Sudhir Swain
	 * Date         : 20-09-2020
   */	
	
	public void enterCredentials(String username, String Password) {
		try{
			
		usrName.sendKeys(username);
		
		passWrd.sendKeys(Password);
		
		loginBtn.click();
		
		Thread.sleep(2000);
		
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		
	
		
		
	}
	
	 /*
		 * Function		: invalidLogin
		 * Parameters	: usenames,passwords
		 * Description	: This method will validate invalidlogin scenario
		 * Author		: Sudhir Swain
		 * Date         : 20-09-2020
	 */
	   
	
       public void invalidLogin(String usenames, String passwords) {
    	   
    	   try {
    		   
    		   
    	   
    	   String[] username = usenames.split(":");
    	   
    	   String[] password = passwords.split(":");
    	   
    	  
    	   
    	   for (int i=0;i<username.length;i++) {
    		   
    		   usrName.sendKeys(username[i]);
    		   
    		   passWrd.sendKeys(password[i]);
    		   
    		   loginBtn.click();
    		   
    		   action.switchToAlert();
    			
    		   action.alertAccept();
    		   
    		   Thread.sleep(2000);
    	   }
    		   
    	   }catch(Exception e) {
    		   
    		   System.out.println(e.getMessage());
    		   
    		   
    	   }
    		   
    		   
    		   
    		   
    	   }
    	   
    	   
    	   
    	   
    	   
    	   
    	   
		
		
       /*
		 * Function		: logout
		 * Parameters	: NA
		 * Description	: This method will logout the user 
		 * Author		: Sudhir Swain
		 * Date         : 20-09-2020
	   */	
	
	public void logout() {
		
		try {
			
			
		
		logoutLink.click();
		
		action.switchToAlert();
		
		action.alertAccept();
		
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		
	}
	

}
