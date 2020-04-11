package com.htc.webdrivergenerator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverGenerator {
	public static WebDriver genDriver() {
		
		
		System.setProperty("webdriver.chrome.driver","E:\\DEVOPS TUTOTIAL\\JARS_SELENIUM\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
		return driver;
		
	}
	
public static WebDriver ffgenDriver() {
		
		
		System.setProperty("webdriver.gecko.driver","D:\\Sayooj\\SELENIUMjars\\geckodriver\\geckodriver.exe");
    	WebDriver driver = new FirefoxDriver();
		return driver;
		
	}
	
	
}
