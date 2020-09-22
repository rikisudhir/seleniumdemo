package com.framework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framwork.util.UIControlsActions;

public class CustomerPage {
	
    WebDriver driver;
	
	UIControlsActions action;
	
	public static String customerid;
	
	
 public CustomerPage(WebDriver driver) {
		
		this.driver=driver;
		
		action = new UIControlsActions(driver);
		
		PageFactory.initElements(driver, this);
		
		
	}
 
 
    @FindBy(linkText="New Customer")
    WebElement newCustomerLink;
    
    @FindBy(className="heading3")
    WebElement newCustomerHeaderTxt;
    
    @FindBy(name="name")
    WebElement customerName;
    
    @FindBy(xpath="//input[@value='f']")
    WebElement genderradio;
    
    @FindBy(id="dob")
    WebElement dobobj;
    
    @FindBy(name="addr")
    WebElement addressTxt;
    
    
    @FindBy(name="city")
    WebElement cityTxt;
    
    
    @FindBy(name="state")
    WebElement stateTxt;
    
    @FindBy(name="pinno")
    WebElement pintxt;
    
    @FindBy(name="telephoneno")
    WebElement mobilenumberTxt;
    
    @FindBy(name="emailid")
    WebElement emailTxt;
    
    @FindBy(name="password")
    WebElement passwordTxt;
    
    
    @FindBy(name="sub")
    WebElement submitBtn;
    
    @FindBy(xpath="//p[@class='heading3']")
    WebElement sucessMessageTxt;
    
    @FindBy(xpath="//table[@id='customer']/tbody/tr[4]/td[2]")
    WebElement customerIdTxt;
    
    
    @FindBy(linkText="Edit Customer")
    WebElement editcustomerLink;
    
    
    @FindBy(xpath="//p[@class='heading3']")
    WebElement editSucesstxt;
    
    
    @FindBy(name="cusid")
    WebElement editCustomerIDTxt;
    
    @FindBy(name="AccSubmit")
    WebElement updateSubmitBtn;
    
    
    




  public String navigatetoNewustomerPage() {
	 
		  
	  
	  
	  newCustomerLink.click();
	  
	  String actualText= newCustomerHeaderTxt.getText();
	  
	  
	  return actualText;
	  
	  
	
  }



public String createNewCustomer(String cusotmerName, String dob, String address, String city, String state, String pin,
		String number, String email, String password) throws InterruptedException {
	
	customerName.sendKeys(cusotmerName);
	
	genderradio.click();
	
	String[] dateofb =dob.split("/");
	
	dobobj.sendKeys(dateofb[0]);
	dobobj.sendKeys(dateofb[1]);
	dobobj.sendKeys(dateofb[2]);
	
	addressTxt.sendKeys(address);
	
	cityTxt.sendKeys(city);
	
	stateTxt.sendKeys(state);
	
	pintxt.sendKeys(pin);
	
	mobilenumberTxt.sendKeys(number);
	
	emailTxt.sendKeys(email);
	
	passwordTxt.sendKeys(password);
	
	
	submitBtn.click();
	
	Thread.sleep(8000);
	
	String sucessmessage= sucessMessageTxt.getText();
	
	customerid =customerIdTxt.getText();
	
	return sucessmessage;
	
	
	
	
	
	
	
	
	
}

public String updateCustomer(String updatedcityname) {
	
	
	editcustomerLink.click();
	
	editCustomerIDTxt.sendKeys(customerid);
	
	updateSubmitBtn.click();
	cityTxt.clear();
	cityTxt.sendKeys(updatedcityname);
	submitBtn.click();
	
	String editsucessmessage= editSucesstxt.getText();
	
	
	
	return editsucessmessage;
	
	
	
}


  
}
