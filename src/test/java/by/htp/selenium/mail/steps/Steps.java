package by.htp.selenium.mail.steps;

import org.openqa.selenium.WebDriver;

import by.htp.selenium.mail.driver.FirefoxSingletonDriver;
import by.htp.selenium.mail.pages.MainPage;

public class Steps {
	private WebDriver driver;

	
	public void initBrowser()
	{
		driver = FirefoxSingletonDriver.getDriver();
	}

	public void closeDriver()
	{
		FirefoxSingletonDriver.closeDriver();
	}

	public void loginMail(String username, String password)
	{
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
		mainPage.login(username, password);
	}

	public boolean checkLogin(String username) {
		MainPage mainPage = new MainPage(driver);
		return mainPage.getLoginResult(username);
	}
	
	public void sendMail() throws InterruptedException {
		MainPage mainPage = new MainPage(driver);
		mainPage.sendMail();
	}
	
	public boolean checkSend() {
		MainPage mainPage = new MainPage(driver);
		return mainPage.checkSend(); 
	}
	/*public boolean isLoggedIn(String username)
	{
		LoginPage loginPage = new LoginPage(driver);
		String actualUsername = loginPage.getLoggedInUserName().trim().toLowerCase();
		logger.info("Actual username: " + actualUsername);
		return actualUsername.equals(username);
	}

	public boolean createNewRepository(String repositoryName, String repositoryDescription)
	{
		MainPage mainPage = new MainPage(driver);
		mainPage.clickOnCreateNewRepositoryButton();
		CreateNewRepositoryPage createNewRepositoryPage = new CreateNewRepositoryPage(driver);
		String expectedRepoName = createNewRepositoryPage.createNewRepository(repositoryName, repositoryDescription);
		return expectedRepoName.equals(createNewRepositoryPage.getCurrentRepositoryName());
	}

	public boolean currentRepositoryIsEmpty()
	{
		CreateNewRepositoryPage createNewRepositoryPage = new CreateNewRepositoryPage(driver);
		return createNewRepositoryPage.isCurrentRepositoryEmpty();
	}*/

}
