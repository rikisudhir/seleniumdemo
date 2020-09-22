package com.framework.pageobjects;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.framwork.util.ConfigParser;

public class BaseClass {
	
	
	
	public static WebDriver driver;
	
	public ConfigParser objConfig;
	
	public ConfigParser testDataConfig;
	
	public static String configFilePath="";
	
	public static String testDataFilePath="";
	
	LoginPage objLogin;
	 
	public  static Logger logger;
	
	
	
	@BeforeClass
	
	@Parameters({"browser"})
	public void setUp(@Optional String browser) throws FileNotFoundException {
		
    if (browser==null) {
    	
    	browser="chrome";
    }
		
    configFilePath = System.getProperty("user.dir")+"/Config/Config.properties";
    
    objConfig =new ConfigParser(configFilePath);
    
    testDataFilePath= System.getProperty("user.dir")+objConfig.getPropertyvalue("testdataFilePath");
    
    testDataConfig =new ConfigParser(testDataFilePath);
    
    if(browser.equals("chrome")) {
    
	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+objConfig.getPropertyvalue("chromeDriverPath") );
	driver=new ChromeDriver();
		
	//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
    }else if(browser.equals("ff")) {
    	
       System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+objConfig.getPropertyvalue("firefoxDriverPath") );
    	
    	driver=new FirefoxDriver();
    	
    }
		
		
	}
	
	
	public void login() {
		
        objLogin= new LoginPage(driver);
		
		driver.navigate().to(objConfig.getPropertyvalue("baseUrl"));
		
		String uname = objConfig.getPropertyvalue("userName");
		
		String passwrd = objConfig.getPropertyvalue("passWord");
		
		driver.manage().window().maximize();
		
		objLogin.enterCredentials(uname,passwrd);
		 
		
		
	}
	
	
	
	
	
	
	@AfterClass
	public void TearDown() {
		
		driver.quit();
	}
	
	
	

}
