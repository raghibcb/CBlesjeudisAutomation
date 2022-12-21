package tests;

import org.testng.annotations.Test;

import controllers.ExcelDataProvider;
import io.qameta.allure.Description;
import pageObjects.initializePageObjects.PageFactoryInitializer;

public class LJSignUpTest extends PageFactoryInitializer {

	@Description("Verify that user is able to SignUp successfully without Resume")
	@Test(dataProvider="excelSheetNameAsMethodName",dataProviderClass=ExcelDataProvider.class)
	public void LJSignUpWithoutResume(String testCaseID,String FirstName,String LastName,String Zipcode,String Password,String confirmPassword) throws Exception
	{   //String zip_code = Integer.toString((int) Zipcode);
		ljSignUpPage().clickOnSignUpLink();
		ljSignUpPage().fillSignUpFormDetails(FirstName, LastName,Zipcode,Password,confirmPassword);
		//ljSignUpPage().uploadResumeFile();
		ljSignUpPage().clickOnIacceptCheckBox();
		ljSignUpPage().clickOnSubmitButton();
		//scrn shoot
		//Again Upload Resume
		//Again Screen shot
		ljSignUpPage().deleteAccoun();
		  
				
	}
	
	@Description("Verify the validation messages for mandatory field on SignUp page")
	@Test(dataProvider="excelSheetNameAsMethodName",dataProviderClass=ExcelDataProvider.class)
	public void LJSignUpAndValidateMandatoryfield(String testCaseID,String FirstName,String LastName,String Zipcode,String Password,String confirmPassword) throws Exception
	{   //String zip_code = Integer.toString((int) Zipcode);
		ljSignUpPage().clickOnSignUpLink();
		ljSignUpPage().clickOnSubmitButton();
		ljSignUpPage().validateMandatoryFieldErrorMessage();
		//scrn
		ljSignUpPage().fillSignUpFormDetailsAndValdateMandatoryFields(FirstName, LastName,Zipcode,Password,confirmPassword);
		ljSignUpPage().uploadResumeFile();
		ljSignUpPage().clickOnVisibleCheckBox();
		ljSignUpPage().ClickIacceptCheckBox();
		ljSignUpPage().clickOnSubmitButton();
		ljSignUpPage().ClickOnSaveCareerGoals();
		ljSignUpPage().verifyVisibleToggleOffAtProfile();
		ljSignUpPage().clickOnContactreferenceTab();
		ljSignUpPage().deleteAccoun();
		  
				
	}
	
	@Description("Verify that user is able to SignUp successfully with Upload Resume Option and resumes details are visible correctly in MyProfile page")
	@Test(dataProvider="excelSheetNameAsMethodName",dataProviderClass=ExcelDataProvider.class)
	public void lJSignUpWithUploadResumeValidateProfileVisibility(String testCaseID,String FirstName,String LastName,String Zipcode,String Password,String confirmPassword) throws Exception
	{   //String zip_code = Integer.toString((int) Zipcode);
		ljSignUpPage().clickOnSignUpLink();
		ljSignUpPage().fillSignUpFormDetails(FirstName, LastName,Zipcode,Password,confirmPassword);
		ljSignUpPage().uploadResumeFile();
		ljSignUpPage().ClickIacceptCheckBox();
		ljSignUpPage().clickOnSubmitButton();
		ljSignUpPage().ClickOnCancelCareerGoals();
		ljSignUpPage().verifyVisibleToggleOnAtProfile();
		ljSignUpPage().clickOnContactreferenceTab();
		ljSignUpPage().ContactreferenceTabSectionScreenShot();
		ljSignUpPage().clickOnDocumentTab();
		//ljSignUpPage().deleteAccoun();
		  
				
	}
	
	@Description("Verify that user is able to SignUp successfully with Copy/Paste Resume Option and resumes details are visible correctly in MyProfile page")
	@Test(dataProvider="excelSheetNameAsMethodName",dataProviderClass=ExcelDataProvider.class)
	public void lJSignUpWithCopyPaste(String testCaseID,String FirstName,String LastName,String Zipcode,String Password,String confirmPassword) throws Exception
	{   //String zip_code = Integer.toString((int) Zipcode);
		ljSignUpPage().clickOnSignUpLink();
		ljSignUpPage().fillSignUpFormDetails(FirstName, LastName,Zipcode,Password,confirmPassword);
		ljSignUpPage().clickOnuploadResumeIcon();
	//ljSignUpPage().uploadResumeFile();
		ljSignUpPage().ReadandCopyPase();
		ljSignUpPage().ClickIacceptCheckBox();
		ljSignUpPage().clickOnSubmitButton();
		ljSignUpPage().ClickOnSaveCareerGoals();
		ljSignUpPage().verifyVisibleToggleOnAtProfileCopy();
		ljSignUpPage().clickOnContactreferenceTab();
		ljSignUpPage().ContactreferenceForCopyPasteTabSectionScreenShot();
		ljSignUpPage().clickOnDocumentTab();
		//ljSignUpPage().deleteAccoun();
		  
				
	}
	
	@Description("Verify that user is able to SignIn successfully with valid credentials")
	@Test(dataProvider="excelSheetNameAsMethodName",dataProviderClass=ExcelDataProvider.class)
	public void ljVerifySignInWithValidCredentials(String testCaseID,String email,String password) throws Exception
	{    
		ljSignUpPage().clickOnSignInLink();
		ljSignUpPage().enterLoginDetailAndSubmit(email,password);
		ljSignUpPage().verifyPageTitle();
		//ljSignUpPage(). veriFyLogOutSuccessfully();	  		
	}
	
	@Description("Verify that user is able to SignIn successfully with valid credentials")
	@Test(dataProvider="excelSheetNameAsMethodName",dataProviderClass=ExcelDataProvider.class)
	public void ljVerifyLogOutSuccessfully(String testCaseID,String email,String password) throws Exception
	{    
		ljSignUpPage().clickOnSignInLink();
		ljSignUpPage().enterLoginDetailAndSubmit(email,password);
		ljSignUpPage().verifyPageTitle();
		ljSignUpPage(). veriFyLogOutSuccessfully();	  		
	}
	
	@Description("Verify that user is able to SignIn with Invalid credentials")
	@Test(dataProvider="excelSheetNameAsMethodName",dataProviderClass=ExcelDataProvider.class)
	public void ljVerifySignInWithInValidCredentials(String testCaseID,String invalidemail,String invalidpassword,String password,String email) throws Exception
	{    
		ljSignUpPage().clickOnSignInLink();
		ljSignUpPage().enterLoginInvalidDetailAndSubmit(invalidemail,invalidpassword);
		ljSignUpPage().verifyWrongToasMessage();
		ljSignUpPage().enterLoginInvalidUserNameDetailAndSubmit(invalidemail,password);
		ljSignUpPage().verifyWrongToastMessageForInvaliduser();
		ljSignUpPage().enterLoginInvalidPasswordDetailAndSubmit(email,invalidpassword);
		//ljSignUpPage().verifyPageTitle();
		//ljSignUpPage(). veriFyLogOutSuccessfully();	  		
	}
	
	@Description("Verify that user is able to SignUp successfully with Build Resume Option and resumes details are visible correctly in MyProfile page")
	@Test(dataProvider="excelSheetNameAsMethodName",dataProviderClass=ExcelDataProvider.class)
	public void ljSignUpUsingBuildResumeOption(String testCaseID,String FirstName,String LastName,String Zipcode,String Password,String confirmPassword,String city,String jobtitle,String company,String Startdatemonth,String Enddatemonth,String Degree,String SchoolName,String SubjectName) throws Exception
	{    
		ljSignUpPage().clickOnSignUpLink();
		//String zipcodeStr = Integer.toString((int) Zipcode);
		ljSignUpPage().fillSignUpFormDetails(FirstName, LastName,Zipcode,Password,confirmPassword);
		ljSignUpPage().clickOnuploadResumeIcon();
		ljSignUpPage().clickOnBuildResumeOption();
		ljSignUpPage().ClickIacceptCheckBox();
		ljSignUpPage().clickOnSubmitButton();
		ljSignUpPage().enterPersonalInforMationForBuildResume(city);
		ljSignUpPage().clickOnPersonalInformationNextButton();
		//scrn
		ljSignUpPage().fillworkhistorydetails(jobtitle,company);
		//String Month = Integer.toString((int) Startdatemonth);
		ljSignUpPage().selectStartdate("0");
		//String EndMonth = Integer.toString((int) Enddatemonth);
		ljSignUpPage().selectEnddate("4");
		ljSignUpPage().clickOnNext();
		ljSignUpPage().fillEducaionDetails(Degree,SchoolName,SubjectName);
		//scrn
		ljSignUpPage().clickOnCreateAccountUsingBuildButtonForSignUp();
		//scrn
		//Last At resume section scrn
		//verify title at document As firstName_LastName.pdf
		//ljSignUpPage().verifyPageTitle();
		//ljSignUpPage(). veriFyLogOutSuccessfully();	  		
	}
	
	@Description("Verify that required details are Automatically added to Career Goals page after user Registers using resume")
	@Test(dataProvider="excelSheetNameAsMethodName",dataProviderClass=ExcelDataProvider.class)
	public void lJVerifyRequiredDetailsAddedAutomatically(String testCaseID,String FirstName,String LastName,String Zipcode,String Password,String confirmPassword) throws Exception
	{   //String zip_code = Integer.toString((int) Zipcode);
		ljSignUpPage().clickOnSignUpLink();
		ljSignUpPage().fillSignUpFormDetails(FirstName, LastName,Zipcode,Password,confirmPassword);
		ljSignUpPage().uploadResumeFile();
		ljSignUpPage().ClickIacceptCheckBox();
		ljSignUpPage().clickOnSubmitButton();
		ljSignUpPage().ClickOnSaveCareerGoals();
		ljSignUpPage().verifyRequiredDetailsAtProfile();
		ljSignUpPage().clickOnDocumentTab();
		ljSignUpPage().documentAndResumeSectionScreenShot();
		//ljSignUpPage().deleteAccoun();
		  
				
	}
}
