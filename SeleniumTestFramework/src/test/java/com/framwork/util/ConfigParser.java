package com.framwork.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigParser {
	
	
	private FileInputStream stream;
	
	private  static Properties configfile= new Properties();
	
	
	public ConfigParser(String filename) throws FileNotFoundException {
		
		try {
			
			
		
		stream = new FileInputStream(filename);
		
		configfile.load(stream);
		
		
		
		}catch(Exception e){
			
			
			System.out.println(e.getMessage());
		}
		
	}
	
	
	public String getPropertyvalue(String attibutename) {
		
		
		return configfile.getProperty(attibutename);
		
	}
	  

}
