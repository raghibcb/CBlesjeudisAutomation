package pageObjects.pages;

import java.io.File;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import controllers.BaseMethod;
import io.qameta.allure.Step;
import pageObjects.initializePageObjects.PageFactoryInitializer;

public class LJMyProfilePageObject extends PageFactoryInitializer {
	
	BaseMethod base = new BaseMethod();
	String filepath = System.getProperty("user.dir") + "/FileToUpload/John_Mclain.doc";
	
	 
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


