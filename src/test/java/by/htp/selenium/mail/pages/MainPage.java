package by.htp.selenium.mail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {
	private final String BASE_URL = "https://mail.ru/";
	private final String RECIEVER = "tathtp@mail.ru";
	private final String REPO_URL = "https://github.com/oandreeva/Homework18.12";
	
	@FindBy(id = "mailbox:login")
	private WebElement loginInput;

	@FindBy(id = "mailbox:password")
	private WebElement passInput;

	@FindBy(xpath = "//*[@id=\"mailbox:submit\"]/input")
	private WebElement submit;

	@FindBy(id = "PH_user-email")
	private WebElement result;

	@FindBy(xpath = "//*[@id=\"b-toolbar__left\"]/div/div/div[2]/div/a/span")
	private WebElement letterButton;

	@FindBy(xpath = "//textarea[@data-original-name='To']")
	private WebElement recieverTextArea;

	@FindBy(xpath = "//input[@name='Subject']")
	private WebElement subjectTextArea;

	@FindBy(xpath = "//iframe[@id~='composeEditor_ifr']")
	private WebElement frame;

	@FindBy(xpath = "//body[@id='tinymce']")
	private WebElement bodyTextArea;

	@FindBy(xpath = "//form[@action='/compose/']")
	private WebElement form;

	@FindBy(xpath = "//*[@id=\"b-toolbar__right\"]/div[3]/div/div[2]/div[1]/div")
	private WebElement sendButton;

	@FindBy(xpath = "//*[@id=\"b-compose__sent\"]/div/div[2]/div[1]/span")
	private WebElement sendResult;

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void login(String login, String password) {
		loginInput.sendKeys(login);
		passInput.sendKeys(password);
		submit.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(driver.getCurrentUrl());

	}

	public boolean getLoginResult(String username) {
		System.out.println(result.getText());
		return result.getText().contains(username);
	}

	public void sendMail() throws InterruptedException {
		letterButton.click();
		Thread.sleep(5000);
		recieverTextArea.sendKeys(RECIEVER);
		subjectTextArea.sendKeys("Homework Andreeva");

		String sessionId = form.getAttribute("id").replace("toolkit-", "").replace("composeForm", "");
		WebElement frame = driver.findElement(By.xpath("//iframe[@id='toolkit-" + sessionId + "composeEditor_ifr']"));
		driver.switchTo().frame(frame);

		WebElement body = driver.findElement(By.xpath("//body[@id='tinymce']"));
		body.sendKeys("Добрый день, Светлана.\n Высылаю ссылку на GitHub. " + REPO_URL);
		
		driver.switchTo().defaultContent();
		
		sendButton.click();
		Thread.sleep(3000);

	}

	public boolean checkSend() {
		return sendResult.getText().equals(RECIEVER);
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}

}
