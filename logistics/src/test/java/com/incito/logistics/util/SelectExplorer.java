package com.incito.logistics.util;
import org.testng.ITestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
public class SelectExplorer {
	
	public WebDriver  selectExplorerByName(String name,ITestContext context){
		 String chromeDriverPath = context.getCurrentXmlTest().getParameter("chromeDriverPath");
		 String ieDriverPath = context.getCurrentXmlTest().getParameter("ieDriverPath");
		if(name.equalsIgnoreCase("chrome")){
			
			System.setProperty("webdriver.chrome.driver",	 chromeDriverPath);
			return  new ChromeDriver();
			
		}else if(name.equalsIgnoreCase("ie")){
			
		     System.setProperty("webdriver.ie.driver", ieDriverPath);
		     DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
		     ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		    return  new InternetExplorerDriver();
			
			
		}else if(name.equalsIgnoreCase("firefox")){
			return new FirefoxDriver();
		
		}else{
			System.out.println("您输入的浏览器名称"+name+"：不被支持，目前支持的有chrome, firefox和IE");
			return null;
		}
		
	}

}
