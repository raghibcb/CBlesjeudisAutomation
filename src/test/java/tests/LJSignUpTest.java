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
		ljSignUpPage().deleteAccoun();
		  
				
	}
	
	@Description("Verify the validation messages for mandatory field on SignUp page")
	@Test(dataProvider="excelSheetNameAsMethodName",dataProviderClass=ExcelDataProvider.class)
	public void LJSignUpAndValidateMandatoryfield(String testCaseID,String FirstName,String LastName,String Zipcode,String Password,String confirmPassword) throws Exception
	{   //String zip_code = Integer.toString((int) Zipcode);
		ljSignUpPage().clickOnSignUpLink();
		ljSignUpPage().clickOnSubmitButton();
		ljSignUpPage().validateMandatoryFieldErrorMessage();
		ljSignUpPage().fillSignUpFormDetailsAndValdateMandatoryFields(FirstName, LastName,Zipcode,Password,confirmPassword);
		ljSignUpPage().uploadResumeFile();
		ljSignUpPage().clickOnVisibleCheckBox();
		ljSignUpPage().ClickIacceptCheckBox();
		ljSignUpPage().clickOnSubmitButton();
		ljSignUpPage().ClickOnSaveCareerGoals();
		ljSignUpPage().deleteAccoun();
		  
				
	}
}
