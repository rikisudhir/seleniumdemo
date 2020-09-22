package com.framework.testcase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.framework.pageobjects.BaseClass;
import com.framework.pageobjects.LoginPage;

public class LoginTest extends BaseClass {
	
	 LoginPage objLogin;
	 
	 public  static Logger logger;
	
	  @BeforeClass
	   public void beforeRun() {
		  
		 logger=LogManager.getLogger();
		  
		 objLogin = new  LoginPage(driver);  
		 
		 logger.info("Opening Aplication URL");
		 
		 driver.navigate().to(objConfig.getPropertyvalue("baseUrl"));
		 
		 driver.manage().window().maximize();
		   
		   
	   }
	  
	  /*
		 * Function		: loginTest
		 * Parameters	: NA
		 * Description	: This method is to validate login fuctionality 
		 * Author		: Sudhir Swain
		 * Date         : 20-09-2020
	   */	
	  
	  @Test(enabled=false)
	  public void loginTest() {
		  
		  try {  
			  
			String uname = objConfig.getPropertyvalue("userName");
			
			String passwrd = objConfig.getPropertyvalue("passWord");
			
			logger.info("Entering Credentials");
		  
		  objLogin.enterCredentials(uname,passwrd);
		  
		  Thread.sleep(6000);
		  
		  if(driver.getCurrentUrl().equals(testDataConfig.getPropertyvalue("landingUrl"))) {
			
			  
			  Assert.assertTrue(true);
			  
			  logger.info("Login sucessfull");
			  
		  }else {
			  
			  Assert.assertTrue(false);
			  
			  
			  logger.info("Login unsucessfull");
			  
			  
			 
			  
			 
			  
			 
		  }
		  }catch(Exception e){
			  
			  System.out.println(e.getMessage());
			  
			  
		  }
		  
	  }
	  
	  
	  @Test
	  
	  public void validateInavlidLogin() {
		  
		  
		  String invalidusernames=testDataConfig.getPropertyvalue("invalidUsernames");
		  
		  String invalidpasswords=testDataConfig.getPropertyvalue("invalidPasswords");
		 
		  
		  objLogin.invalidLogin(invalidusernames, invalidpasswords);
		  
		  
		  if(driver.getCurrentUrl().equals(objConfig.getPropertyvalue("baseUrl"))) {
			
			  
			  Assert.assertTrue(true);
			  
			  logger.info("Login sucessfull");
			  
		  }else {
			  
			  Assert.assertTrue(false);
			  
			  
			  logger.info("Login unsucessfull");
			  
		  }
		  
		  
		  
		  
	  }
	  
	  
	  @Test(enabled=false)
	  
	  public void validateLogout() {
		  
		  
		  objLogin.logout();
		  
		  if(driver.getCurrentUrl().equals(testDataConfig.getPropertyvalue("logoutUrl"))) {
			  
			  Assert.assertTrue(true);
			  
			  logger.info("logout sucessful");
			  
			  
		  }else {
			  
			  Assert.assertTrue(false);
			  
			  logger.info("logout unsucessful");
			  
		  }
		  
		  
		  
		  
	  }
	  
	  
	 
	 
	
	
	  
	
	
	
	

}
