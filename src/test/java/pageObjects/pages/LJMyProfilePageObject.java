package pageObjects.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import controllers.BaseMethod;
import io.qameta.allure.Step;
import pageObjects.initializePageObjects.PageFactoryInitializer;

public class LJMyProfilePageObject extends PageFactoryInitializer {
	
	BaseMethod base = new BaseMethod();
	String filepath = System.getProperty("user.dir") + "/FileToUpload/John_Mclain.doc";

	@Step("navigate to my Profile page")
	public LJMyProfilePageObject navigateToMyProfile() throws Exception {
      getWebDriver().get(WebsiteURL+"/myprofile");
      return this;
		
	}
	
	@Step("navigate to my Profile page")
	public LJMyProfilePageObject clickOnRemoveOrAddResumeLink() throws Exception {
      getWebDriver().get(WebsiteURL+"/resume/replace_resume_file");
      return this;
		
	}
	
	@FindBy(xpath="//button[contains(@id,'upload-resume-icon')]")
	private WebElement uploadResumeButton;
	
	@FindBy(id="upload_file")
	private WebElement uploadFile;
	
	@Step("click On upload Resume Icon")
	public LJMyProfilePageObject clickOnuploadResumeIcon() throws Exception {
		uploadResumeButton.click();
		return this;
	}
	
	@FindBy(xpath="//input[@id='submit-resume-upload']")
	private WebElement submitCopyPasteResume;
	
	@FindBy(xpath="//span[contains(text(),'Félicitations, vous avez réussi à télécharger un nouveau CV.')]")
	private WebElement copyToastMessage;
	
	@Step("click On upload Resume Icon")
	public LJMyProfilePageObject clickOnUploadCopyPasteResumeButton() throws Exception {
		submitCopyPasteResume.click();
		return this;
	}
	
	@Step("click On upload Resume Icon")
	public LJMyProfilePageObject verifyCopyPasteToastMessage() throws Exception {
		copyToastMessage.isDisplayed();
		Thread.sleep(20000);
		saveFullPageMultiPleScreenshot("./src/test/resources/Reports/Images/tests.LJMypofileTest/lJVerifyUserAbleToAddResumeeWithCopyPaste/" + "toastMesageCopyPasteSrc" + ".png");
	    Thread.sleep(3000);
		return this;
	}
	
	@Step("click On upload Resume Icon")
	public LJMyProfilePageObject verifyToastMessage() throws Exception {
		copyToastMessage.isDisplayed();
		return this;
	}
	
	@Step("upload resume")
	public LJMyProfilePageObject uploadResumeFile() throws Exception {
		
		//utils.ScrollUtils.scrollByPixel(200);
		//uploadResumeButton.click();
		base.mousehover(uploadFile);
		uploadFile.sendKeys(filepath);
		return this;
	}
	
	@Step("upload resume")
	public LJMyProfilePageObject scrShootAtUploadResume() throws Exception {
		Thread.sleep(8000);
	saveFullPageMultiPleScreenshot("./src/test/resources/Reports/Images/tests.LJMypofileTest/lJVerifyUserAbleToAddResumeeWithUploadResume/" + "uploadResumeFileSrc" + ".png");
			 Thread.sleep(3000);
		return this;
	}
}


