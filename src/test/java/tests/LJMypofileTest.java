package tests;

import org.testng.annotations.Test;

import controllers.ExcelDataProvider;
import io.qameta.allure.Description;
import pageObjects.initializePageObjects.PageFactoryInitializer;

public class LJMypofileTest extends PageFactoryInitializer {

	@Description("Verify that user is able replace/add the existing resume using Copy/Paste Resume Option and correct details are visible on Resume page")
	@Test(dataProvider="excelSheetNameAsMethodName",dataProviderClass=ExcelDataProvider.class)
	public void lJVerifyUserAbleToAddResumeeWithCopyPaste(String testCaseID,String email,String password) throws Exception
	{   //String zip_code = Integer.toString((int) Zipcode);
		ljSignUpPage().clickOnSignInLink();
		ljSignUpPage().enterLoginDetailAndSubmit(email,password);
		ljSignUpPage().verifyPageTitle();
		ljMyProfilePage().navigateToMyProfile();
		ljSignUpPage().clickOnDocumentTab();
		ljMyProfilePage().clickOnRemoveOrAddResumeLink();
		ljMyProfilePage().clickOnuploadResumeIcon();
		ljSignUpPage().ReadandCopyPaseForAddResume();
		ljMyProfilePage().clickOnUploadCopyPasteResumeButton();
		ljMyProfilePage().verifyCopyPasteToastMessage(); 
		ljSignUpPage().clickOnDocumentTab();
		//ljSignUpPage().deleteAccoun();
		  
				
	}
	
	@Description("Verify that user is able replace/add the existing resume using Upload Resume Option and correct details are visible on Resume page")
	@Test(dataProvider="excelSheetNameAsMethodName",dataProviderClass=ExcelDataProvider.class)
	public void lJVerifyUserAbleToAddResumeeWithUploadResume(String testCaseID,String email,String password) throws Exception
	{   //String zip_code = Integer.toString((int) Zipcode);
		ljSignUpPage().clickOnSignInLink();
		ljSignUpPage().enterLoginDetailAndSubmit(email,password);
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
		//ljSignUpPage().deleteAccoun();
		  
				
	}
	
}
