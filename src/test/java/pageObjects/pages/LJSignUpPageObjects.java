package pageObjects.pages;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import controllers.BaseMethod;
import io.qameta.allure.Step;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import utils.RandomGenerator;

public class LJSignUpPageObjects extends PageFactoryInitializer {
    
	BaseMethod base = new BaseMethod();
	String filepath = System.getProperty("user.dir") + "/FileToUpload/RESUME-DGuthries.docx";
	
	@FindBy(xpath="//a[contains(text(),'Déposer un CV')]")
	private WebElement signUpLink;
	
	@FindBy(xpath="//a[@id=\"signin-link\"]")
	private WebElement signInLink;
	
	@FindBy(xpath = "//*[contains(text(),'Candidat, connectez-vous')]")
	private WebElement signInPageText;

	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailTextBox;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordTextBox;

	@FindBy(xpath = "//input[@id='submit-login']")
	private WebElement signInButton;
	
	@FindBy(xpath="//div[@class=\"menu-links-right\"]")
	private WebElement accountMenue;
	
	@FindBy(xpath = "//a[@id='logout-link']")
	private WebElement logOutLink;
	
	@FindBy(xpath="(//span[contains(text(),'ou le mot de passe sont invalides.')])[2]")
	private WebElement wrongToastMessage;
	
	@Step(" Log On CareerBuilder.com")
	public LJSignUpPageObjects verifyWrongToasMessage() throws Exception { 
		
		utils.ExplicitWaiting.explicitWaitVisibilityOfElement(wrongToastMessage, 30);
		Thread.sleep(8000);
		saveFullPageMultiPleScreenshot("./src/test/resources/Reports/Images/tests.LJSignUpTest/ljVerifySignInWithInValidCredentials/" + "MessageInvalidUserInvalidPassword" + ".png");
				 Thread.sleep(3000);
		return this;
	}
	
	@Step(" Log On CareerBuilder.com")
	public LJSignUpPageObjects verifyWrongToastMessageForInvaliduser() throws Exception { 
		
		utils.ExplicitWaiting.explicitWaitVisibilityOfElement(wrongToastMessage, 30);
		Thread.sleep(8000);
		saveFullPageMultiPleScreenshot("./src/test/resources/Reports/Images/tests.LJSignUpTest/ljVerifySignInWithInValidCredentials/" + "MessageForInvaliduser" + ".png");
				 Thread.sleep(3000);
		return this;
	}
	
	@Step(" Log On CareerBuilder.com")
	public LJSignUpPageObjects enterLoginDetailAndSubmit(String emailID, String password) throws Exception { 
		
		utils.ExplicitWaiting.explicitWaitVisibilityOfElement(signInPageText, 120);
		emailTextBox.sendKeys(emailID);
		passwordTextBox.sendKeys(password);
		utils.ScrollUtils.scrollByPixel(100);
		signInButton.click();
		return this;
	}
	@Step(" Log On CareerBuilder.com")
	public LJSignUpPageObjects enterLoginInvalidDetailAndSubmit(String emailID, String password) throws Exception { 
		
		utils.ExplicitWaiting.explicitWaitVisibilityOfElement(signInPageText, 120);
		emailTextBox.sendKeys(emailID);
		passwordTextBox.sendKeys(password);
		utils.ScrollUtils.scrollByPixel(100);
		signInButton.click();
		return this;
	}
	
	@Step(" Log On CareerBuilder.com")
	public LJSignUpPageObjects enterLoginInvalidUserNameDetailAndSubmit(String emailID, String password) throws Exception { 
		
		//utils.ExplicitWaiting.explicitWaitVisibilityOfElement(signInPageText, 120);
		emailTextBox.clear();
		emailTextBox.sendKeys(emailID);
		passwordTextBox.sendKeys(password);
		utils.ScrollUtils.scrollByPixel(100);
		signInButton.click();
		return this;
	}
	
	@Step(" Log On CareerBuilder.com")
	public LJSignUpPageObjects enterLoginInvalidPasswordDetailAndSubmit(String emailID, String password) throws Exception { 
		
		//utils.ExplicitWaiting.explicitWaitVisibilityOfElement(signInPageText, 120);
		emailTextBox.clear();
		emailTextBox.sendKeys(emailID);
		passwordTextBox.sendKeys(password);
		utils.ScrollUtils.scrollByPixel(100);
		signInButton.click();
		return this;
	}
	
	
	@Step("Verify Page Title of CareerBuilder ")
	public LJSignUpPageObjects verifyPageTitle() throws Exception {
		Thread.sleep(10000);
		utils.ExplicitWaiting.explicitWaitTitleContains(60, "Emploi Informatique et Digital | Lesjeudis.com");
		Assert.assertEquals(getWebDriver().getTitle(), "Emploi Informatique et Digital | Lesjeudis.com");
		return this;
	}
	
	@Step("Verify that candidate is able to logout successfully")
	public LJSignUpPageObjects veriFyLogOutSuccessfully() throws Exception {
		
		utils.ExplicitWaiting.explicitWaitVisibilityOfElement(accountMenue,60);
		base.mousehover(accountMenue);
        logOutLink.click();
 
//		getWebDriver().get(WebsiteURL+"/user/logout");
//		String actualLogOutUrl = getWebDriver().getCurrentUrl();
//		Assert.assertTrue(actualLogOutUrl.contains("/?logout=true"));

		return this;
	}
	@Step("click on sign up link")
	public LJSignUpPageObjects clickOnSignUpLink() throws Exception {
		//utils.ExplicitWaiting.explicitWaitVisibilityOfElement(signUpLink, 60);
		try{
			//getWebDriver().get(WebsiteURL+"/?force_ab_test_simplified_registration=default");
			utils.ExplicitWaiting.explicitWaitVisibilityOfElement(signUpLink, 60);
			JSclick(signUpLink);
			//signUpLink.click();
			//getWebDriver().get(WebsiteURL+"/user/register?forcenewux=exp1");
		}catch(Exception e) {
			getWebDriver().get(WebsiteURL+"/user/register");
			e.printStackTrace();
		}
		return this;
	}
	
	@Step("click on sign up link")
	public LJSignUpPageObjects clickOnSignInLink() throws Exception {
		 
		try{
			utils.ExplicitWaiting.explicitWaitVisibilityOfElement(signInLink, 60);
			JSclick(signInLink);
		}catch(Exception e) {
			getWebDriver().get(WebsiteURL+"/user/login");
			e.printStackTrace();
		}
		return this;
	}
	
	@FindBy(id = "firstname")
	private WebElement firstNameTextField;

	@FindBy(id = "lastname")
	private WebElement lastNameTextField;
	
	@FindBy(id = "postalcode")
	private WebElement zipCode;
	
	@FindBy(id="submit-login")
	private WebElement saveButtonAtLetsFewDetailPage;

	@FindBy(id = "password")
	private WebElement passwordTextField;
	
    @FindBy(id = "confirm_passwd")
	private WebElement confirmPasswordTextField;
	
	@FindBy(xpath="//input[@id=\"email\"]")
	private WebElement enterEmailAddress;
	

	@FindBy(xpath="//button[contains(@id,'upload-resume-icon')]")
	private WebElement uploadResumeButton;
	
	@FindBy(id="upload_file")
	private WebElement uploadFile;
	
	@FindBy(xpath="//a[@id=\"js-copy-paste-trigger\"]")
	private WebElement uploadFileWithcopyPaste;
	
	@FindBy(xpath="//a[@id=\"js-copy-paste-validate\"]")
	private WebElement copyPaseValidteButton;
	
	@FindBy(xpath="//a[@id=\"js-copy-paste-cancel\"]")
	private WebElement copyPasecancelButton;
	
	@FindBy(id = "submit-register-user")
	private WebElement createAccountButton;
	
	@FindBy(xpath="//label[@for=\"tac\"]")
	private WebElement IacceptCheckbox;
	
	@FindBy(xpath="//label[@for=\"resume_application_email\"]")
	private WebElement alertCheckBox;
	
	@FindBy(xpath="//label[@for=\"job_reco_email\"]")
	private WebElement jobReferCheckBox;
	
	@FindBy(xpath="//label[@for=\"resume_visibility\"]")
	private WebElement resumeVisibiltyCheckBox;
	
	@FindBy(xpath="//button[@id='delete-account-btn']")
	private WebElement deleteAccountLink;
	
	@FindBy(xpath="//button[@id='confirm-delete-account']")
	private WebElement deleteAccountButton;
	
	@FindBy(id="error-message-firstname")
	private WebElement errMessageFName;
	
	@FindBy(id="error-message-lastname")
	private WebElement errMessageLName;
	
	@FindBy(id="error-message-postalcode")
	private WebElement errMessagePostalCode;
	
	@FindBy(id="error-message-postalcode")
	private WebElement errMessagePassword;
	
	@FindBy(id="error-message-postalcode")
	private WebElement errMessageConfirmPassword;
	
	@FindBy(id="error-message-email")
	private WebElement errMessageEmailAddress;
	
	@FindBy(xpath="//input[@id='save-career-goals']")
	private WebElement saveCareerGoals;
	
	@FindBy(xpath="//a[contains(text(),'Passer cette étape')]")
	private WebElement skipThisStepAtCareerGoals;
	
	@FindBy(xpath="//input[@name=\"toggle-check\" and @checked=\"checked\"]")
	private WebElement visibleToggleAtProfileOn;
	
	@FindBy(xpath="//input[@class=\"slide-checkbox onoffswitch-checkbox\"]")
	private WebElement visibleToggleAtProfileOFF;
	
	@FindBy(xpath="//a[@id=\"profile_contact_pref_tab\"]")
	private WebElement contactPreferenceTab;
	
	@FindBy(xpath="//a[@id=\"profile_documents_tab\"]")
	private WebElement documetTab;
	
	@FindBy(id="copy_paste")
	private WebElement Copypaste;
	
	@Step("enter email address")
	public LJSignUpPageObjects enterEmailAddress() throws Exception {
		Thread.sleep(10000); 
		String stringName=RandomGenerator.GenerateRandomSmallLetters(7);
		Thread.sleep(5000);
		enterEmailAddress.click();
		enterEmailAddress.sendKeys("vegita_goku_32" + stringName + "@yopmail.com");
		System.out.println("email address::"+"vegita_goku_32" + stringName + "@yopmail.com");
		String useremail=enterEmailAddress.getAttribute("value");
		System.out.println("provided email"+useremail); 
		return this;
	}
	
	@SuppressWarnings({ "resource", "static-access" })
	@Step("Read and Copy Paste")
	public LJSignUpPageObjects ReadandCopyPase()throws Exception{
		base.mousehover(uploadFileWithcopyPaste);
		uploadFileWithcopyPaste.click();
		 XWPFDocument doc = new XWPFDocument(Files.newInputStream(Paths.get(filepath)));
		XWPFWordExtractor xwpfWordExtractor = new XWPFWordExtractor(doc);
	     String docText = xwpfWordExtractor.getText();
	     StringSelection stringSelection = new StringSelection(docText);
	     Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	     clipboard.setContents(stringSelection, null);
	     Thread.sleep(10);
	     Copypaste.sendKeys(Keys.SHIFT, Keys.INSERT);
	     Thread.sleep(20);
	     Thread.sleep(20000);
			saveFullPageMultiPleScreenshot("./src/test/resources/Reports/Images/tests.LJSignUpTest/lJSignWithCopyPaste/" + "lJSignWithCopyPasteSrc" + ".png");
		    Thread.sleep(3000);
	     copyPaseValidteButton.click();
		return this;
}

	
	@Step("fill sign up details")
	public LJSignUpPageObjects fillSignUpFormDetailsAndValdateMandatoryFields(String firstName, String lastName,String zipcode,String password,String confirmPassword) throws Exception {
		 
		firstNameTextField.sendKeys(firstName);
		lastNameTextField.sendKeys(lastName);
		enterEmailAddress();
		zipCode.sendKeys("95880");
		passwordTextField.sendKeys(password);
		confirmPasswordTextField.sendKeys(confirmPassword);
		return this;
	}
	
	@Step("fill sign up details")
	public LJSignUpPageObjects validateMandatoryFieldErrorMessage() throws Exception {
		errMessageFName.isDisplayed();
		errMessageLName.isDisplayed();
		errMessageEmailAddress.isDisplayed();
		errMessagePostalCode.isDisplayed();
		errMessagePassword.isDisplayed();
		errMessageConfirmPassword.isDisplayed();
		return this;
	}
	
	@Step("fill sign up details")
	public LJSignUpPageObjects fillSignUpFormDetails(String firstName, String lastName,String zipcode,String password,String confirmPassword) throws Exception {
		 
		firstNameTextField.sendKeys(firstName);
		lastNameTextField.sendKeys(lastName);
		enterEmailAddress();
		zipCode.sendKeys("95880");
		passwordTextField.sendKeys(password);
		confirmPasswordTextField.sendKeys(confirmPassword);
		return this;
	}
	
	@Step("upload resume")
	public LJSignUpPageObjects uploadResumeFile() throws Exception {
		
		utils.ScrollUtils.scrollByPixel(200);
		uploadResumeButton.click();
		base.mousehover(uploadFile);
		uploadFile.sendKeys(filepath);
		Thread.sleep(8000);
	saveFullPageMultiPleScreenshot("./src/test/resources/Reports/Images/tests.LJSignUpTest/LJSignUpAndValidateMandatoryfield/" + "uploadResumeFileSrc" + ".png");
			 Thread.sleep(3000);
		return this;
	}
	
	@Step("upload resume")
	public LJSignUpPageObjects clickOnuploadResumeIcon() throws Exception {
		utils.ScrollUtils.scrollByPixel(200);
		uploadResumeButton.click();
		return this;
	}
	
	@Step("click on submit button")
	public LJSignUpPageObjects clickOnSubmitButton() throws Exception {
		utils.ScrollUtils.scrollToElement(createAccountButton);
		utils.ExplicitWaiting.explicitWaitElementToBeClickable(createAccountButton, 60);
		createAccountButton.click();
		return this;
	}
	
	@Step("click on submit button")
	public LJSignUpPageObjects deleteAccoun() throws Exception {
		Thread.sleep(7000);
		 getWebDriver().get(WebsiteURL+"/user/edit");
		 deleteAccountLink.click();
		 deleteAccountButton.click();
		return this;
	}
	
	@Step("click on submit button")
	public LJSignUpPageObjects clickOnIacceptCheckBox() throws Exception {
		utils.ScrollUtils.scrollByPixel(300);
		utils.ExplicitWaiting.explicitWaitElementToBeClickable(IacceptCheckbox, 60);
		//IacceptCheckbox.click();
		JSclick(IacceptCheckbox);
		Thread.sleep(30000);
		saveFullPageMultiPleScreenshot("./src/test/resources/Reports/Images/tests.LJSignUpTest/LJSignUpWithoutResume/" + "PersonaldetailseSrc" + ".png");
	    Thread.sleep(3000);
		return this;
	}
	
	@Step("click on submit button")
	public LJSignUpPageObjects ClickIacceptCheckBox() throws Exception {
		utils.ScrollUtils.scrollByPixel(300);
		utils.ExplicitWaiting.explicitWaitElementToBeClickable(IacceptCheckbox, 60);
		//IacceptCheckbox.click();
		JSclick(IacceptCheckbox);
		return this;
	}
	
	@Step("click on submit button")
	public LJSignUpPageObjects clickOnVisibleCheckBox() throws Exception {
		utils.ScrollUtils.scrollToElement(resumeVisibiltyCheckBox);
		utils.ExplicitWaiting.explicitWaitElementToBeClickable(resumeVisibiltyCheckBox, 60);
		//resumeVisibiltyCheckBox.click();
		JSclick(resumeVisibiltyCheckBox);
		Thread.sleep(30000);
		saveFullPageMultiPleScreenshot("./src/test/resources/Reports/Images/tests.LJSignUpTest/LJSignUpAndValidateMandatoryfield/" + "VisibleCheckboxUnchecked" + ".png");
	    Thread.sleep(3000);
		return this;
	}
	
	@Step("click on save career goals")
	public LJSignUpPageObjects ClickOnSaveCareerGoals() throws Exception {
		//utils.ScrollUtils.scrollByPixel(300);
		utils.ScrollUtils.scrollToBottom();
		utils.ExplicitWaiting.explicitWaitElementToBeClickable(saveCareerGoals, 60);
		saveCareerGoals.click();
		return this;
	}
	
	@Step("click on  skip save career goals")
	public LJSignUpPageObjects ClickOnCancelCareerGoals() throws Exception {
		//utils.ScrollUtils.scrollByPixel(300);
		utils.ScrollUtils.scrollToBottom();
		utils.ExplicitWaiting.explicitWaitElementToBeClickable(skipThisStepAtCareerGoals, 60);
		skipThisStepAtCareerGoals.click();
		return this;
	}
	
	@Step("visible toggle On")
	public LJSignUpPageObjects verifyVisibleToggleOnAtProfile() throws Exception {
	    //utils.ExplicitWaiting.explicitWaitElementToBeClickable(visibleToggleAtProfileOn, 60);
		visibleToggleAtProfileOn.isDisplayed();
		Thread.sleep(30000);
		saveFullPageMultiPleScreenshot("./src/test/resources/Reports/Images/tests.LJSignUpTest/lJSignUpWithUploadResumeValidateProfileVisibility/" + "VisibleCheckboxON" + ".png");
	    Thread.sleep(3000);
		return this;
	}
	
	@Step("visible toggle On")
	public LJSignUpPageObjects verifyVisibleToggleOnAtProfileCopy() throws Exception {
	    //utils.ExplicitWaiting.explicitWaitElementToBeClickable(visibleToggleAtProfileOn, 60);
		visibleToggleAtProfileOn.isDisplayed();
		Thread.sleep(30000);
		saveFullPageMultiPleScreenshot("./src/test/resources/Reports/Images/tests.LJSignUpTest/lJSignUpWithCopyPaste/" + "CopypasteVisibleCheckboxON" + ".png");
	    Thread.sleep(3000);
		return this;
	}
	
	@Step("visible toggle off")
	public LJSignUpPageObjects verifyVisibleToggleOffAtProfile() throws Exception {
	    utils.ExplicitWaiting.explicitWaitVisibilityOfElement(visibleToggleAtProfileOn, 60);
		visibleToggleAtProfileOn.isDisplayed();
		Thread.sleep(30000);
		saveFullPageMultiPleScreenshot("./src/test/resources/Reports/Images/tests.LJSignUpTest/LJSignUpAndValidateMandatoryfield/" + "VisibleCheckboxUncheckedOFF" + ".png");
	    Thread.sleep(3000);
		return this;
	}
	
	@Step("visible toggle off")
	public LJSignUpPageObjects clickOnContactreferenceTab() throws Exception {
	    utils.ExplicitWaiting.explicitWaitElementToBeClickable(contactPreferenceTab, 60);
	    contactPreferenceTab.click();
		return this;
	}
	
	@Step("visible toggle off")
	public LJSignUpPageObjects ContactreferenceTabSectionScreenShot() throws Exception {
	    Thread.sleep(30000);
		saveFullPageMultiPleScreenshot("./src/test/resources/Reports/Images/tests.LJSignUpTest/lJSignWithUploadResumeValidateProfileVisibility/" + "contactPreferences" + ".png");
	    Thread.sleep(3000);
		return this;
	}
	
	@Step("visible toggle off")
	public LJSignUpPageObjects ContactreferenceForCopyPasteTabSectionScreenShot() throws Exception {
	    Thread.sleep(30000);
		saveFullPageMultiPleScreenshot("./src/test/resources/Reports/Images/tests.LJSignUpTest/lJSignUpWithCopyPaste/" + "contactPreferencesCopyPaste" + ".png");
	    Thread.sleep(3000);
		return this;
	}
	
	@Step("visible toggle off")
	public LJSignUpPageObjects clickOnDocumentTab() throws Exception {
	    utils.ExplicitWaiting.explicitWaitElementToBeClickable(documetTab, 60);
	    documetTab.click();
		return this;
	}
	
	
}
