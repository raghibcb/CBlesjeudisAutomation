package pageObjects.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.qameta.allure.Step;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import utils.AllureAttachments;
import utils.ExplicitWaiting;


public class CBLoginPageObjects extends PageFactoryInitializer
{
	@FindBy(xpath="//input[starts-with(@placeholder,'Email')]")
	private WebElement emailIDTextBox;
	
	@FindBy(xpath="//input[starts-with(@value,'Next')]")
	private WebElement nextbtn;
	
	@FindBy(xpath="//input[starts-with(@placeholder,'Pa')]")
	private WebElement passwordTextBox;
	
	@FindBy(xpath="//input[starts-with(@value,'Sign in')]")
	private WebElement signInButton;
	
	@FindBy(xpath="//input[starts-with(@value,'Yes')]")
	private WebElement staysigin;
	
	@FindBy(xpath="//*[@id='ShellMail_link']")
	private WebElement clickoutlooklink;
	
	@Step("Log into On CareerBuilder Home Page")
	public CBLoginPageObjects enterEmailID(String emailID,String password) throws Exception
	{
		AllureAttachments.saveWebElement(getWebDriver(), emailIDTextBox);
		
		
		utils.ExplicitWaiting.explicitWaitVisibilityOfElement(emailIDTextBox, 120);
		emailIDTextBox.sendKeys(emailID);	
		
		nextbtn.click();
		AllureAttachments.saveWebElement(getWebDriver(), passwordTextBox);
		passwordTextBox.sendKeys(password);
		AllureAttachments.saveWebElement(getWebDriver(), signInButton);
		signInButton.click();
		Thread.sleep(4000);
		staysigin.click();
		utils.ExplicitWaiting.explicitWaitVisibilityOfElement(clickoutlooklink, 120);
		clickoutlooklink.click();
		
		
		AllureAttachments.attachFileType_XLSX(ExcelFiles + "TestData.xlsx");
		return this;
	}
	@Step("")
	public CBLoginPageObjects switchWindow() {
		String parent=getWebDriver().getWindowHandle();
		Set<String>s=getWebDriver().getWindowHandles();
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())	{
			String child_window=I1.next();
			if(!parent.equals(child_window)){
				getWebDriver().switchTo().window(child_window);
				System.out.println(getWebDriver().switchTo().window(child_window).getTitle());
				//getWebDriver().close();
			}
		}
		//switch to the parent window
		//driver.switchTo().window(parent);
		return this;
	}
	@FindBy(xpath="//*[text()='New message']")
	private WebElement newmail;
	
	@FindBy(xpath="//*[@aria-label='To']")
	private WebElement To;
	
	@FindBy(xpath="//*[starts-with(@placeholder,'Add')]")
	private WebElement subject;
	
	@FindBy(xpath="//*[starts-with(@aria-label,'Message body')]")
	private WebElement msgbody;

	@FindBy(xpath="//button[starts-with(@aria-label,'Send') and @title='Send (Ctrl+Enter)']")
	private WebElement sendbtn;
	
	@Step("Verify Page Title of CareerBuilder Home Page")
	public CBLoginPageObjects outlookmailsend() throws Exception 
	{
		Thread.sleep(5000);
		newmail.click();
		
		To.sendKeys("ankush.singh12@outlook.com");
		subject.sendKeys("subject");
		
		WebDriverWait eb=new WebDriverWait(getWebDriver(),120);
		eb.until(ExpectedConditions.visibilityOf(msgbody));
		msgbody.sendKeys("testing");
		
		Thread.sleep(4000);
		sendbtn.click();
		
		
		return this;
	}
	
	
	
}
