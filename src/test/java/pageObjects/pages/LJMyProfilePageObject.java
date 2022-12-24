package pageObjects.pages;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import controllers.BaseMethod;
import io.qameta.allure.Step;
import pageObjects.initializePageObjects.PageFactoryInitializer;

public class LJMyProfilePageObject extends PageFactoryInitializer {
	
	BaseMethod base = new BaseMethod();
	String filepath = System.getProperty("user.dir") + "/FileToUpload/John_Mclain.doc";
	 
	static String getJobTitle,getdesiredlocation,getdesiredsalary,getcurrency,getfrequency,getemployementtype;
	 
	String Resumedownloadpath="//src/test//resources//Download";

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
	//==========Goal Test========
	
	@FindBy(xpath="//a[contains(text(),'Modifier Objectifs Professionnels')]")
	private WebElement editLink;
	
	@FindBy(xpath="//h2[contains(text(),'Career Goals')]")
	private WebElement careergoals;
	
	@FindBy(xpath="//input[@id='desired_jobtitle']")
	private WebElement jobTitle;
	
	@FindBy(xpath="//input[starts-with(@id,'target_pay_value')]")
	private WebElement desireSalary;
	
	@FindBy(xpath="//select[@id='target_pay_currency']")
	private WebElement currency;
	
	public WebElement selectCurrency(String currencyName) {
		WebElement element = getWebDriver()
				.findElement(By.xpath("//select[starts-with(@id,'target_pay_currency')]/option[contains(text(),\"" + currencyName + "\")]"));
		return element;
	}
	
	@FindBy(xpath="//select[@id='target_pay_frequency']")
	private WebElement frequency;
	
	public WebElement selectFrequency(String frequencyName) {
		WebElement element = getWebDriver()
				.findElement(By.xpath("//select[starts-with(@id,'target_pay_frequency')]/option[contains(text(),\"" + frequencyName + "\")]"));
		return element;
	}
	
	@FindBy(xpath="//div[@class='selectize-control emp-types-select multi plugin-remove_button']//div[@class='selectize-input items not-full has-options has-items']//input")
	private WebElement desireEmployeementtype;
	
	@FindBy(xpath="//label[@for='availability_1']")
	private WebElement clickopen;
	
	@FindBy(xpath="//input[@name='commit']")
	private WebElement savegoals;
	
	@FindBy(xpath="//span[contains(text(),'Desired Job Title:')]//parent::div//following-sibling::div//child::span")
	private WebElement jobtitleheading;
	
	public WebElement verifyjobtitle(String jobtitle) {
		WebElement element = getWebDriver()
				.findElement(By.xpath("//span[@class='b'][contains(text(),'"+jobtitle+"')]"));
		return element;
	}
	
	//New changes 
	
		public WebElement verifyDesirelocation(String Location) {
			WebElement element = getWebDriver().findElement(By.xpath("//span[contains(text(),'"+Location+"')]"));
			return element;
		}
		
		public WebElement verifysalary(String salary,String frequencyName) {
			WebElement element = getWebDriver()
					.findElement(By.xpath("//span[contains(text(),'$"+salary+" par "+"mois')]"));
			return element;
		}
		
		public WebElement verifyremotecheckbox() {
			WebElement element = getWebDriver().findElement(By.xpath("//span[contains(text(),'(Open to Remote positions)')]"));
					return element;
		}
		
		public WebElement verifyEmployeementtype(String Employeementtype) {
			WebElement element = getWebDriver().findElement(By.xpath("//span[contains(text(),'"+Employeementtype+"')]"));
			return element;
		}
		
		
		//Previous data verify changes
		public WebElement verifypreviousjobtitle() {
			WebElement element = getWebDriver()
					.findElement(By.xpath("//span[@class='b'][contains(text(),'"+getJobTitle+"')]"));
			return element;
		}
		
		public WebElement verifyprevioussalary() {
			WebElement element = getWebDriver()
					.findElement(By.xpath("//span[contains(text(),'"+getdesiredsalary+" "+"per month')]"));
			return element;
		}
		
//		@FindBy(xpath="//span[contains(text(),'Desired Location(s):')]//parent::div//following-sibling::div")
//		private WebElement location;
		
		
		
		@FindBy(xpath="//span[contains(text(),'$78635 per month')]")
		private WebElement verifysalary;
		
		@FindBy(xpath="//span[contains(text(),'Open to opportunity')]")
		private WebElement verifyavailabity;
		
		@Step("Edit link")
		public LJMyProfilePageObject editlink() throws Exception{
			utils.ExplicitWaiting.explicitWaitElementToBeClickable(editLink,60);
			editLink.click();
			return this;
			
		}
		
		//13th july changes
		@FindBy(xpath="//div[@data-value='Orlando, FL']")
		private WebElement locationvalue;
		
		@FindBy(xpath="(//*[@class=\"selectize-dropdown-content\"])[1]")
		private WebElement locationvalueFirst;
		
		
		@FindBy(xpath="//div[@data-value='ETPE']")
		private WebElement employementdatavalue;
		
		@FindBy(xpath="//div[@class='selectize-control relocations-select multi plugin-remove_button']//div[@class='selectize-input items not-full has-options has-items']//input")
		private WebElement desireLocation;
		
		@FindBy(xpath="//span[contains(text(),'Where do you want to work?')]")
		private WebElement heading;
		
		@FindBy(xpath="//label[@for='remote_work']")
		private WebElement checkRemotebutton;
		
		@Step("Enter all Details")
		public LJMyProfilePageObject EnterDetails(String jobtitle, String Location,String salary,String currencyName,String frequencyName,String Employeementtype) throws Exception{
		utils.ExplicitWaiting.explicitWaitVisibilityOfElement(jobTitle, 10);
		getJobTitle=jobTitle.getAttribute("value");
		System.out.println(getJobTitle);
		getdesiredsalary=desireSalary.getAttribute("value");
		System.out.println(getdesiredsalary);
		se = new Select(currency);
		WebElement options=se.getFirstSelectedOption();
		getcurrency=options.getText();
		System.out.println(getcurrency);
		se = new Select(frequency);
		WebElement optio=se.getFirstSelectedOption();
		getfrequency=optio.getText();
		System.out.println(getfrequency);
		jobTitle.click();
		jobTitle.clear();
		jobTitle.sendKeys(jobtitle);
		//new changes
		//desireLocation.sendKeys(Location);
		Thread.sleep(3000);
		//locationvalue.click();
		//locationvalueFirst.click();
		Thread.sleep(3000);
		
		
		
//		utils.ExplicitWaiting.explicitWaitElementToBeClickable(desireLocation, 50);
//		heading.isDisplayed();
		
//		desireLocation.click();
//		base.hitBackspace();
	//	
		
//		selectLocation(location).click();
		
//		checkRemotebutton.isSelected();
		
		desireSalary.click();
		desireSalary.clear();
		desireSalary.sendKeys(salary);
		Thread.sleep(2000);
		//checkRemotebutton.click();
		selectCurrency(currencyName).click();
		selectFrequency(frequencyName).click();	
		Thread.sleep(2000);
//	utils.ExplicitWaiting.explicitWaitElementToBeClickable(desireEmployeementtype, 120);
//		desireEmployeementtype.sendKeys(Employeementtype);
//		Thread.sleep(3000);
//		employementdatavalue.click();
	//	
//		clickopen.click();
		
		
//		Thread.sleep(2000);
//		desireEmployeementtype.sendKeys(Keys.TAB);
		
		
//		Thread.sleep(20);
//		desireEmployeementtype.clear();
//		base.hitBackspace();
		
//		selectEmployment(employment).click();
		
//		utils.ExplicitWaiting.explicitWaitElementToBeSelected(clickopen, 40);
//		clickopen.isSelected();
		utils.ScrollUtils.scrollByPixel(200);
		utils.ExplicitWaiting.explicitWaitVisibilityOfElement(savegoals, 40);
		//savegoals.click();
		JSclick(savegoals);
		

			return this;
		}
		
		@Step("Candidate Verify Details")
		public LJMyProfilePageObject VerfiyDetails(String jobtitle,String Location,String salary,String currency,String frequencyName,String Employeementtype) throws Exception{
			utils.ExplicitWaiting.explicitWaitVisibilityOfElement(verifyjobtitle(jobtitle), 20);
			verifyjobtitle(jobtitle).isDisplayed();
//			location.isDisplayed();
			verifyDesirelocation(Location).isDisplayed();
			Thread.sleep(10000);
			try {
			verifyremotecheckbox().isDisplayed();
			}
			catch(Exception e)
			{
				e.getStackTrace();
			}
			verifysalary(salary,frequencyName).isDisplayed();
			//verifyEmployeementtype(Employeementtype).isDisplayed();
//			utils.ExplicitWaiting.explicitWaitVisibilityOfElement(verifysalary(salary, currency,frequency), 20);
//			verifysalary(salary, currency,frequency).isDisplayed();
			//verifyavailabity.isDisplayed();
			return this;
		}
		
		
	
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
	public LJMyProfilePageObject scrShootAtUploadResumeForDownoadResume() throws Exception {
		Thread.sleep(8000);
	saveFullPageMultiPleScreenshot("./src/test/resources/Reports/Images/tests.LJMypofileTest/lJVerifyUserAbleToDownLoadAddResume/" + "uploadResumeFileSrcForDownload" + ".png");
			 Thread.sleep(3000);
		return this;
	}
	
	@Step("upload resume")
	public LJMyProfilePageObject scrShootAtUploadResume() throws Exception {
		Thread.sleep(8000);
	saveFullPageMultiPleScreenshot("./src/test/resources/Reports/Images/tests.LJMypofileTest/lJVerifyUserAbleToAddResumeeWithUploadResume/" + "uploadResumeFileSrc" + ".png");
			 Thread.sleep(3000);
		return this;
	}
	

	public boolean isFileDownloaded(String Resumedownloadpath, String fileName) {
		boolean flag = false;
	    File dir = new File(Resumedownloadpath);
	    File[] dir_contents = dir.listFiles();
	  	    
	    for (int i = 0; i < dir_contents.length; i++) {
	        if (dir_contents[i].getName().equals(fileName))
	            return flag=true;
	            }

	    return flag;
	}
	
	private boolean isFileDownloaded_Ext(String Resumedownloadpath, String ext){
		boolean flag=false;
	    File dir = new File(Resumedownloadpath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        flag = false;
	    }
	    
	    for (int i = 0; i < files.length; i++) {
	    	if(files[i].getName().contains(ext)) {
	    		flag=true;
	    	}
	    }
	    return flag;
	}
	
	
	private File getLatestFilefromDir(String dirPath){
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        return null;
	    }
	
	    File lastModifiedFile = files[0];
	    for (int i = 1; i < files.length; i++) {
	       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
	           lastModifiedFile = files[i];
	       }
	    }
	    return lastModifiedFile;
	}
	//previous version xpath
//	@FindBy(xpath="//td[@class='col col-mobile-full']//child::a[@href='/resume/download?profile_id=XRDF8BF5XHWV5TG66VH9']")
//	private WebElement downloadlink;
	
	//new xpath
	@FindBy(xpath="//tbody//tr//td[4]//a[2]")
	private List<WebElement> downloadlink;
	
	@FindBy(xpath="(//*[@class=\"fa fa-download\"])[1]")
	private WebElement firstDownoadIcion;
	
	public LJMyProfilePageObject verifyResumeDownloaded() {
        String fileName = utils.CommonUtils.getFileName(Resumedownloadpath);
        System.out.println("length of file"+fileName.length());
        Assert.assertTrue(fileName.length()>=1);
        utils.CommonUtils.verifyFileDownloaded(Resumedownloadpath,fileName);
        return this;
    }
	
	
	@Step("download Resume")
	public LJMyProfilePageObject downloadResume()throws Exception{
		utils.CommonUtils.cleanDirectory(Resumedownloadpath);
		try {
			firstDownoadIcion.click();
		}
		catch(Exception e)
		{
		 
		}
		Thread.sleep(50000);
		
		verifyResumeDownloaded();
		try {
		if(isFileDownloaded_Ext(Resumedownloadpath,".txt")) {
			Assert.assertTrue(isFileDownloaded_Ext(Resumedownloadpath,".txt"), "Failed to download document which has extension .docx");
			}
			else if(isFileDownloaded_Ext(Resumedownloadpath,".pdf")) {
				Assert.assertTrue(isFileDownloaded_Ext(Resumedownloadpath, ".pdf"), "Failed to download document which has extension .pdf");
			}
			else if(isFileDownloaded_Ext(Resumedownloadpath,".docx")) {
				Assert.assertTrue(isFileDownloaded_Ext(Resumedownloadpath, ".docx"), "Failed to download document which has extension .txt");
			}
			else {
				System.out.println("File Not Found");
			}
		}catch(Exception e) {
			e.getStackTrace();
			System.out.println("file not downloaded");
		}
		

		
	
		return this;
	}

}


