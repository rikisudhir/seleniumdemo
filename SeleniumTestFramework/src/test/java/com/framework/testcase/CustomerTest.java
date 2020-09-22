package com.framework.testcase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.framework.pageobjects.BaseClass;
import com.framework.pageobjects.CustomerPage;
import com.framework.pageobjects.LoginPage;

public class CustomerTest extends BaseClass{
	
	LoginPage objLogin;
	
	CustomerPage custobj;
	 
	public  static Logger logger;
	
	
	@BeforeClass
	public void beforeRun() {
		
		logger=LogManager.getLogger();
		
		login();
		
		logger.info("login sucessfull");
		
		custobj = new CustomerPage(driver);
		
	
		
	}
		
		@Test(priority=1)
		public void validateNewCustomerpage() {
			
			
			 String expectedtext = testDataConfig.getPropertyvalue("newCustomerHeader");
			
			
			
			   String actualtext=custobj.navigatetoNewustomerPage();
				
			   Assert.assertEquals(actualtext, expectedtext);
			
			
			
		}
		
		
		@Test(priority=2)
		
		public void validateCreateNewCustomer() throws InterruptedException {
			
			
			String cusotmerName =testDataConfig.getPropertyvalue("cusotmerName");
			
			String dob =testDataConfig.getPropertyvalue("dob");
			String address =testDataConfig.getPropertyvalue("address");
			String city =testDataConfig.getPropertyvalue("city");
			String state =testDataConfig.getPropertyvalue("state");
			String pin =testDataConfig.getPropertyvalue("pin");
			String number =testDataConfig.getPropertyvalue("number");
			String email =testDataConfig.getPropertyvalue("email");
			String password =testDataConfig.getPropertyvalue("password");
			
			
			String exepctedsucessmessage= testDataConfig.getPropertyvalue("sucessmessage");
			
		
			String actualsucessmessage=custobj.createNewCustomer(cusotmerName,dob,address,city,state,pin,number,email,password);
			
			
			Assert.assertEquals(exepctedsucessmessage, actualsucessmessage);
				
		
			
			
			
			
		}
		
		@Test(priority=3)
		
		   public void validateEditCustomer() {
			
			
			String updatedcity= testDataConfig.getPropertyvalue("updatedCity");
			
			String exepctedupdatesucessmessage= testDataConfig.getPropertyvalue("updatesucessmessage");
			
			String actualupdatesucessmessage= custobj.updateCustomer(updatedcity);
			
			Assert.assertEquals(exepctedupdatesucessmessage, actualupdatesucessmessage);
			
			
			
			
		}
	}


