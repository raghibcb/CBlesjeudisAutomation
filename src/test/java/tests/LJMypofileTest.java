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
		ljMyProfilePage().clickOnRemoveOrAddResumeLink();
		ljMyProfilePage().clickOnuploadResumeIcon();
		ljSignUpPage().ReadandCopyPaseForAddResume();
		ljMyProfilePage().clickOnUploadCopyPasteResumeButton();
		ljMyProfilePage().verifyCopyPasteToastMessage();
		ljSignUpPage().clickOnDocumentTab();
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
		ljMyProfilePage().clickOnRemoveOrAddResumeLink();
		ljMyProfilePage().clickOnuploadResumeIcon();
		ljMyProfilePage().uploadResumeFile();
		ljMyProfilePage().scrShootAtUploadResume();
		ljMyProfilePage().clickOnUploadCopyPasteResumeButton();
		ljMyProfilePage().verifyToastMessage();
		ljSignUpPage().clickOnDocumentTab();
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
		ljSignUpPage().clickOnCreateAccountUsingBuildButton();
		ljMyProfilePage().verifyToastMessage();
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
		ljMyProfilePage().clickOnRemoveOrAddResumeLink();
		ljMyProfilePage().clickOnuploadResumeIcon();
		ljMyProfilePage().uploadResumeFile();
		ljMyProfilePage().scrShootAtUploadResume();
		ljMyProfilePage().clickOnUploadCopyPasteResumeButton();
		ljMyProfilePage().verifyToastMessage();
		ljSignUpPage().clickOnDocumentTab();
		ljMyProfilePage().downloadResume();
		// ljSignUpPage().deleteAccoun();

	}

}
