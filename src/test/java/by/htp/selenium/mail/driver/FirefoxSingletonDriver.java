package by.htp.selenium.mail.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxSingletonDriver {
	 private static WebDriver driver;
	   
	 private static final String DRIVER_FIREFOX = "webdriver.gecko.driver";
		private static final String DRIVER_FIREFOX_PATH = "D:\\driver\\geckodriver.exe";

	   

	    public static WebDriver getDriver(){
	        if (null == driver){
	            System.setProperty(DRIVER_FIREFOX, DRIVER_FIREFOX_PATH);
	            driver = new FirefoxDriver();
	            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	            driver.manage().window().maximize();
	            System.out.println("Browser started");
	        }

	        return driver;
	    }

	    public static void closeDriver(){
	        driver.quit();
	        driver = null;
	    }
}
