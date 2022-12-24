package tests;

import org.testng.annotations.Test;

import controllers.ExcelDataProvider;
import io.qameta.allure.Description;
import pageObjects.initializePageObjects.PageFactoryInitializer;

public class LJMypofileTest extends PageFactoryInitializer {

	@Description("Verify that user is able replace/add the existing resume using Copy/Paste Resume Option and correct details are visible on Resume page")
	@Test(dataProvider = "excelSheetNameAsMethodName", dataProviderClass = ExcelDataProvider.class)
	public void lJVerifyUserAbleToAddResumeeWithCopyPaste(String testCaseID, String email, String password)
			throws Exception { // String zip_code = Integer.toString((int) Zipcode);
		ljSignUpPage().clickOnSignInLink();
		ljSignUpPage().enterLoginDetailAndSubmit(email, password);
		ljSignUpPage().verifyPageTitle();
		ljMyProfilePage().navigateToMyProfile();
		ljSignUpPage().clickOnDocumentTab();
		ljSignUpPage().MyResumeForCopyPasteTabSectionScreenShot();
		//src
		ljMyProfilePage().clickOnRemoveOrAddResumeLink();
		ljMyProfilePage().clickOnuploadResumeIcon();
		ljSignUpPage().ReadandCopyPaseForAddResume();
		//src
		ljMyProfilePage().clickOnUploadCopyPasteResumeButton();
		ljMyProfilePage().verifyCopyPasteToastMessage();
		//ljSignUpPage().clickOnDocumentTab();
		ljSignUpPage().screenShotForUploadCopyPastekOnDocumentTab();
		//src
		// ljSignUpPage().deleteAccoun();

	}

	@Description("Verify that user is able replace/add the existing resume using Upload Resume Option and correct details are visible on Resume page")
	@Test(dataProvider = "excelSheetNameAsMethodName", dataProviderClass = ExcelDataProvider.class)
	public void lJVerifyUserAbleToAddResumeeWithUploadResume(String testCaseID, String email, String password)
			throws Exception { // String zip_code = Integer.toString((int) Zipcode);
		ljSignUpPage().clickOnSignInLink();
		ljSignUpPage().enterLoginDetailAndSubmit(email, password);
		ljSignUpPage().verifyPageTitle();
		ljMyProfilePage().navigateToMyProfile();
		ljSignUpPage().clickOnDocumentTab();
		ljSignUpPage(). MyResumeTabForUploadScreenShot();
		//scr
		ljMyProfilePage().clickOnRemoveOrAddResumeLink();
		ljMyProfilePage().clickOnuploadResumeIcon();
		ljMyProfilePage().uploadResumeFile();
		ljMyProfilePage().scrShootAtUploadResume();
		ljMyProfilePage().clickOnUploadCopyPasteResumeButton();
		ljMyProfilePage().verifyToastMessage();
		//ljSignUpPage().clickOnDocumentTab();
		ljSignUpPage().screenShotForUploadResumeOnDocumentTab();
		// ljSignUpPage().deleteAccoun();

	}

	@Description("Verify that user is able replace/add the existing resume using Build Resume Option and correct details are visible on Resume page")
	@Test(dataProvider = "excelSheetNameAsMethodName", dataProviderClass = ExcelDataProvider.class)
	public void lJVerifyUserAbleToAddResumeeWithBuildOption(String testCaseID, String email, String password,
			String city, String jobtitle, String company, String Degree, String SchoolName, String SubjectName)
			throws Exception { // String zip_code = Integer.toString((int) Zipcode);
		ljSignUpPage().clickOnSignInLink();
		ljSignUpPage().enterLoginDetailAndSubmit(email, password);
		ljSignUpPage().verifyPageTitle();
		ljMyProfilePage().navigateToMyProfile();
		ljSignUpPage().clickOnDocumentTab();
		ljMyProfilePage().clickOnRemoveOrAddResumeLink();
		//scrn
		ljMyProfilePage().clickOnuploadResumeIcon();
		ljSignUpPage().clickOnBuildResumeOption();
		ljMyProfilePage().clickOnUploadCopyPasteResumeButton();
		ljSignUpPage().enterPersonalInforMationForBuildResume(city);
		ljSignUpPage().clickOnPersonalInformationNextButton();
		ljSignUpPage().fillworkhistorydetails(jobtitle, company);
		
		// String Month = Integer.toString((int) Startdatemonth);
		ljSignUpPage().selectStartdate("0");
		// String EndMonth = Integer.toString((int) Enddatemonth);
		ljSignUpPage().selectEnddate("4");
		ljSignUpPage().clickOnNext();
		ljSignUpPage().fillEducaionDetails(Degree, SchoolName, SubjectName);
		//scrn
		ljSignUpPage().clickOnCreateAccountUsingBuildButton();
		//ljMyProfilePage().verifyToastMessage();
		ljSignUpPage().clickOnDocumentTab();
		// ljSignUpPage().deleteAccoun();

	}
	
	@Description("Verify that user is able download the added resume from Resume page")
	@Test(dataProvider = "excelSheetNameAsMethodName", dataProviderClass = ExcelDataProvider.class)
	public void lJVerifyUserAbleToDownLoadAddResume(String testCaseID, String email, String password)
			throws Exception { 
		// String zip_code = Integer.toString((int) Zipcode);
		ljSignUpPage().clickOnSignInLink();
		ljSignUpPage().enterLoginDetailAndSubmit(email, password);
		ljSignUpPage().verifyPageTitle();
		ljMyProfilePage().navigateToMyProfile();
		ljSignUpPage().clickOnDocumentTab();
		//ljSignUpPage().screenShotBeforeDownloadOnDocumentTab();
		//scr
		ljMyProfilePage().clickOnRemoveOrAddResumeLink();
		ljMyProfilePage().clickOnuploadResumeIcon();
		ljMyProfilePage().uploadResumeFile();
		ljMyProfilePage().scrShootAtUploadResumeForDownoadResume();
		ljMyProfilePage().clickOnUploadCopyPasteResumeButton();
		ljMyProfilePage().verifyToastMessage();
		//ljSignUpPage().clickOnDocumentTab();
		ljSignUpPage().screenShotBeforeDownloadOnDocumentTab();
		ljMyProfilePage().downloadResume();
		// ljSignUpPage().deleteAccoun();

	}
	
	@Description("Verify that user is able to edit the required field on Career Goals page")
	@Test(dataProvider = "excelSheetNameAsMethodName", dataProviderClass = ExcelDataProvider.class)
	public void lJeditandupdateCareergoals(String testCaseID, String email, String password,String jobtitle,String Location,double salary,String currencyName,String frequencyName,String Employeementtype)
			throws Exception { 
		// String zip_code = Integer.toString((int) Zipcode);
		ljSignUpPage().clickOnSignInLink();
		ljSignUpPage().enterLoginDetailAndSubmit(email, password);
		ljSignUpPage().verifyPageTitle();
		ljMyProfilePage().navigateToMyProfile();
		ljMyProfilePage().editlink();
		String Salary=Integer.toString((int) salary);
		ljMyProfilePage().EnterDetails(jobtitle,Location,Salary,currencyName,frequencyName,Employeementtype);
		ljMyProfilePage().VerfiyDetails(jobtitle,Location,Salary, currencyName,frequencyName,Employeementtype);
		 

	}


}
