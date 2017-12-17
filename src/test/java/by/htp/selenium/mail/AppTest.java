package by.htp.selenium.mail;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.htp.selenium.mail.steps.Steps;

/**
 * Unit test for simple App.
 */
public class AppTest {
	private Steps steps;
	private final String USERNAME = "htp-tat5-andreeva";
	private final String PASSWORD = "12345qwert";

	@BeforeMethod(description = "Init browser")
	public void setUp()
	{
		steps = new Steps();
		steps.initBrowser();
	}

	@Test
	public void sendMail() throws InterruptedException
	{
		steps.loginMail(USERNAME, PASSWORD);
		Assert.assertTrue(steps.checkLogin(USERNAME));
		
		steps.sendMail();
		Assert.assertTrue(steps.checkSend());
		
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser()
	{
		steps.closeDriver();
	}
}
